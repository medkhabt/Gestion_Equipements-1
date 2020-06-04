import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ReservationsService } from 'src/app/services/reservations.service';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { AutorisationsService } from 'src/app/services/autorisations.service';

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
  constructor(private route: Router,
              private reservationServce: ReservationsService,
              private router: ActivatedRoute,
              private formbuilder: FormBuilder,
              private autorisationService: AutorisationsService) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.reservationServce.getReservation(this.id).subscribe(
      res => {
        this.reservation = res;
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
    this.gestionnaire = JSON.parse(localStorage.getItem('demandeur'));
    this.initForm();
  }
  initForm() {
    this.autorisationForm = this.formbuilder.group({
      type: [ '' , [Validators.required] ],
      dateReservation: ['', [Validators.required]],
      dateFin: ['', [Validators.required]],
      objectif: ['first autorisation!!', [Validators.required]]
    });
    this.reservationForm = this.formbuilder.group({
      comment: ['', [Validators.required]]
    });
  }
  valider() {
    const reservation = this.reservation;
    const objectif = this.autorisationForm.get('objectif').value;
    const autorisation = {
      reservation,
      objectif
    };
    this.autorisationService.addAutorisation(autorisation).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
    this.reservation.etat = 'validée';
    this.reservation.commentaire = this.reservationForm.get('comment').value;
    console.log(this.reservation.commentaire);
    this.reservation.gestionnaire = this.gestionnaire;
    this.reservationServce.updateReservation(this.reservation, this.reservation.id).subscribe(
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

  rejeter() {
    this.reservation.etat = 'rejetée';
    this.reservation.gestionnaire = this.gestionnaire;
    this.reservationServce.updateReservation(this.reservation, this.reservation.id).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }


}
