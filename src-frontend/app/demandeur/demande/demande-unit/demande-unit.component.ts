import { Component, OnInit, Input } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations.service';

@Component({
  selector: 'app-demande-unit',
  templateUrl: './demande-unit.component.html',
  styleUrls: ['./demande-unit.component.scss']
})
export class DemandeUnitComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('demandeUnit') demande: any;
  reservation: any;
  constructor(private reservationService: ReservationsService) { }

  ngOnInit(): void {
    console.log(this.demande);
    this.reservationService.getReservationByDemande(this.demande.id).subscribe(
      res => this.reservation = res
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


}
