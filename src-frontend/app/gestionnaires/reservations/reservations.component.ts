import { Component, OnInit } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.scss']
})
export class ReservationsComponent implements OnInit {
  reservations: any;

  constructor(private reservationsService: ReservationsService) { }

  ngOnInit(): void {
    this.reservationsService.getAllReservations();
    this.reservations = this.reservationsService.getReservations();
    console.log(this.reservations);
  }

}
