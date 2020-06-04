import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-reservation-view',
  templateUrl: './reservation-view.component.html',
  styleUrls: ['./reservation-view.component.scss']
})
export class ReservationViewComponent implements OnInit {

  @Input() reservationId: number;
  @Input() dateDemande: Date;
  @Input() objet: string;
  constructor() { }

  ngOnInit(): void {
  }

}
