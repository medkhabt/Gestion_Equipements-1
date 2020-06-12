import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReservationsService } from 'src/app/services/reservations.service';

@Component({
  selector: 'app-demande-view',
  templateUrl: './demande-view.component.html',
  styleUrls: ['./demande-view.component.scss']
})
export class DemandeViewComponent implements OnInit {

  reservation: any;
  id: number;
  constructor(private router: ActivatedRoute,
              private reserrvationService: ReservationsService) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.reserrvationService.getReservation(this.id).subscribe(
      res => {
        this.reservation = res;
        console.log(this.reservation);
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
