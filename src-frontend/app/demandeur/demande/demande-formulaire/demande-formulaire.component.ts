import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Demandeur } from 'src/app/models/utilisateur.model';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { DemandeService } from 'src/app/services/demande.service';
import { AuthService } from 'src/app/services/auth.service';
import { EquipementsService } from 'src/app/services/equipements.service';
import { ReservationsService } from 'src/app/services/reservations.service';
import { Reservation } from 'src/app/models/reservation.model';

@Component({
  selector: 'app-demande-formulaire',
  templateUrl: './demande-formulaire.component.html',
  styleUrls: ['./demande-formulaire.component.scss']
})
export class DemandeFormulaireComponent implements OnInit {
  demandeForm: FormGroup;
  errorMessage: string;
  message: any;
  user: Demandeur;
  userSubjection: Subscription;
  username: string;
  id: number;
  constructor(private formbuilder: FormBuilder,
              private demandeSrevice: DemandeService,
              private authService: AuthService,
              private equipementService: EquipementsService,
              private reservationService: ReservationsService) { }

  ngOnInit() {
    this.user = this.authService.getUser();
    console.log(this.user);
    this.initForm();
  }

  initForm() {
    this.demandeForm = this.formbuilder.group({
      typeEvent: [ '' , [Validators.required] ],
      dateReservation: ['', [Validators.required]],
      objet: ['', [Validators.required]],
      equipement: ['', [Validators.required]],
      nombrePresent: ['', [Validators.required]],
      description: ['', [Validators.required]],
      demandeur: [this.user],
      dateDemande: [new Date()]
    });
  }
  onSubmit() {
    //  const form = this.demandeForm.value;
    console.log(this.demandeForm.get('demandeur'));
    this.demandeSrevice.addDemande(this.demandeForm.value).subscribe(
      resp => {
        localStorage.setItem('demande', JSON.stringify(resp));
        console.log(resp);
      }, err => {
        console.log(err);
      }
    );
    this.addReservation();
  }
  addReservation() {
    const id = this.demandeForm.get('equipement').value;
    this.equipementService.getEquipement(id).subscribe(
      res => {
        localStorage.setItem('equipement', JSON.stringify(res));
        console.log(res);
      }
    );

    // tslint:disable-next-line: prefer-const

    console.log(JSON.parse(localStorage.getItem('equipement')));
    const demande = JSON.parse(localStorage.getItem('demande'));
    const equipement = JSON.parse(localStorage.getItem('equipement'));
    const etat = 'initial';
    const reservation = {
      demande,
      equipement,
      etat
    };
    this.reservationService.addReservation(reservation).subscribe(
      resp => {
        console.log(resp);
      }, err => {
        console.log(err);
      }
    );
  }
}
