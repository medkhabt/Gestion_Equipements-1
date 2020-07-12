import { Component, OnInit } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations.service';
import { AuthService } from 'src/app/services/auth.service';
import { EquipementsService } from 'src/app/services/equipements.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Equipement } from 'src/app/models/equipement.model';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.scss']
})
export class ReservationsComponent implements OnInit {
  reservations: any;
  demandes: any;
  data: any;
  i: number;
  gestionnaire: any;
  equipements: any;
  FilterForm: FormGroup;
  searchEquipementSubject: any;
  searchEtatSubject: any;
  searchObjetSubject: any;
  constructor(private reservationsService: ReservationsService,
              private authservice: AuthService,
              private equipementService: EquipementsService,
              private formbuilder: FormBuilder) { }

  ngOnInit(): void {
    this.reservationsService.getAllReservations().subscribe(
      resp => this.reservations = resp,
      err => console.log(err)
    );
    this.equipementService.getEquipements().subscribe(
      resp => {
        this.equipements = resp;
        console.log(this.equipements);
      }
    );
  //  this.reservations = JSON.parse(localStorage.getItem('reservations'));
    this.demandes = this.authservice.getUser().demandes;
    this.gestionnaire = JSON.parse(localStorage.getItem('gestionnaire'));
    this.initForm();
  }
  initForm() {
    this.FilterForm = this.formbuilder.group({
      equipement: [ 0 , [Validators.required] ],
      etat: [ 'none' , [Validators.required] ]
    });
  }
  onSubmit() {
    if (this.FilterForm.invalid ) {
     return;
    }
    const etat = this.FilterForm.get('etat').value;
    const equipement = this.FilterForm.get('equipement').value;
    this.reservationsService.getReservationsByEtatAndEquipement(etat, equipement).subscribe(
      resp => {
        this.reservations = resp;
      }, err => console.log(err)
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
  setData(d: any) {
    this.data = d;
  }
  getData() {
    console.log(this.data);
    return this.data;
  }
  changeState(reservation: any) {
    console.log(reservation);
    reservation.etat = 'en train de traitement';
    this.reservationsService.updateReservation(reservation, this.gestionnaire.id).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }

}
