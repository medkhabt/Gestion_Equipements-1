import { Component, OnInit } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations.service';
import { AuthService } from 'src/app/services/auth.service';

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
  constructor(private reservationsService: ReservationsService,
              private authservice: AuthService) { }

  ngOnInit(): void {
    this.reservationsService.getAllReservations();
    this.reservations = this.reservationsService.getReservations();
    console.log(this.reservations);
    this.demandes = this.authservice.getUser().demandes;
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

}
