import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReservationsService } from 'src/app/services/reservations.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-demande-detail',
  templateUrl: './demande-detail.component.html',
  styleUrls: ['./demande-detail.component.scss']
})
export class DemandeDetailComponent implements OnInit {

  id: any; // id reservation
  reservation: any;
  obligation: any;
  constructor(private router: ActivatedRoute,
              private reservationService: ReservationsService,
              private authservice: AuthService) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.reservationService.getReservation(this.id).subscribe(
      resp => {
        this.reservation = resp;
        console.log(resp);
        this.obligation = 'data:application/pdf;base64,' + this.reservation.demande.obligationScanne;
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

}
