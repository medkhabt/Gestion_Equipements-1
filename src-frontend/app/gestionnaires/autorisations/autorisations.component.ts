import { Component, OnInit } from '@angular/core';
import { AutorisationsService } from 'src/app/services/autorisations.service';
import { ReservationsService } from 'src/app/services/reservations.service';
import { EquipementsService } from 'src/app/services/equipements.service';

@Component({
  selector: 'app-autorisations',
  templateUrl: './autorisations.component.html',
  styleUrls: ['./autorisations.component.scss']
})
export class AutorisationsComponent implements OnInit {

  autorisations: any;
  demandeur: any;
  searchObjetSubject: any;
  searchEtatSubject: any;
  searchEquipementSubject: any;
  equipements: any;
  constructor(private autorisationservice: AutorisationsService,
              private reservationService: ReservationsService,
              private equipementService: EquipementsService) { }

  ngOnInit(): void {
    this.autorisationservice.getAutorisations().subscribe(
      res => this.autorisations = res,
      err => console.log(err)
    );
    this.equipementService.getEquipements().subscribe(
      resp => {
        this.equipements = resp;
        console.log(this.equipements);
      }
    );
  //  this.autorisations = JSON.parse(localStorage.getItem('autorisations'));
    console.log(this.autorisations);
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

}
