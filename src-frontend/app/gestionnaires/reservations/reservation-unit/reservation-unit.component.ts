import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ReservationsService } from 'src/app/services/reservations.service';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { AutorisationsService } from 'src/app/services/autorisations.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-reservation-unit',
  templateUrl: './reservation-unit.component.html',
  styleUrls: ['./reservation-unit.component.scss']
})
export class ReservationUnitComponent implements OnInit {

  reservation: any;
  id: number;
  gestionnaire: any;
  autorisationForm: FormGroup;
  demandeur: any;
  reservationForm: FormGroup;
  comment: string;
  obligation: any;
  constructor(private route: Router,
              private reservationServce: ReservationsService,
              private router: ActivatedRoute,
              private formbuilder: FormBuilder,
              private autorisationService: AutorisationsService,
              private authservice: AuthService) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.reservationServce.getReservation(this.id).subscribe(
      res => {
        this.reservation = res;
        this.obligation = 'data:application/pdf;base64,' + this.reservation.demande.obligationScanne;
        this.reservationServce.getDemandeurByDemande(this.reservation.demande.id).subscribe(
          resp => {
            this.demandeur = resp;
          }, err => {
            console.log(err);
          }
        );
      }, err => {
        console.log(err);
      }
    );

    // this.reservation = JSON.parse(localStorage.getItem('reservation'));
    this.gestionnaire = JSON.parse(localStorage.getItem('gestionnaire'));
    this.authservice.getGestionnaire(this.gestionnaire.username).subscribe(
      resp => {
        this.gestionnaire = resp;
        console.log(resp);
      }, err => console.log(err)
    );
    this.initForm();
  }
  initForm() {
    this.autorisationForm = this.formbuilder.group({
      type: [ '' , [Validators.required] ],
      dateReservation: ['', [Validators.required]],
      dateFin: ['', [Validators.required]],
      objectif: ['', [Validators.required]]
    });
    this.reservationForm = this.formbuilder.group({
      comment: ['', [Validators.required]]
    });
  }
  valider() {
    const reservation = this.reservation;
    const objectif = this.autorisationForm.get('objectif').value;
    const dateAutorisation = new Date();
    const autorisation = {
      reservation,
      objectif,
      dateAutorisation
    };
    // pour en ajouter dans reserv
    let auto: any;
    this.autorisationService.addAutorisation(autorisation).subscribe(
      res => {
        console.log(res);
        auto = res;
      },
      err => console.log(err)
    );
    this.reservation.etat = 'validée';
    this.reservation.commentaire = this.reservationForm.get('comment').value;
    this.reservation.autorisation = auto;
    console.log(this.reservation.commentaire);
    this.reservation.gestionnaire = this.gestionnaire;
    console.log(this.reservation.gestionnaire);
    this.reservationServce.updateReservation(this.reservation, this.gestionnaire.id).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }

  formatDate(date) {
    const d = new Date(date);
    let month = '' + (d.getMonth() + 1);
    let day = '' + d.getDate();
    const year = d.getFullYear();

    if (month.length < 2) {
    month = '0' + month;
    }
    if (day.length < 2) {
    day = '0' + day;
    }

    return [year, month, day].join('-');
  }

  rejeter(comment: any) {
    this.reservation.etat = 'rejetée';
    this.reservation.gestionnaire = this.gestionnaire;
    this.reservation.commentaire = comment;
    this.reservationServce.updateReservation(this.reservation, this.gestionnaire.id).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }

  mettreEnAttente() {
    this.reservation.etat = 'en cours de traitement';
    this.reservationServce.updateReservation(this.reservation, this.gestionnaire.id).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }

}
