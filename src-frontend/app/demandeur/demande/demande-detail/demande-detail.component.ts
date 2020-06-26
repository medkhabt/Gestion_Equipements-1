import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReservationsService } from 'src/app/services/reservations.service';
import { AuthService } from 'src/app/services/auth.service';
import { AutorisationsService } from 'src/app/services/autorisations.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-demande-detail',
  templateUrl: './demande-detail.component.html',
  styleUrls: ['./demande-detail.component.scss']
})
export class DemandeDetailComponent implements OnInit {

  id: any; // id reservation
  reservation: any;
  obligation: any;
  recepisse: any;
  fileName = 'autorisation';
  constructor(private router: ActivatedRoute,
              private reservationService: ReservationsService,
              private authservice: AuthService,
              private autorisationService: AutorisationsService) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.reservationService.getReservation(this.id).subscribe(
      resp => {
        this.reservation = resp;
        this.obligation = 'data:application/pdf;base64,' + this.reservation.demande.obligationScanne;
      //  localStorage.setItem('obligation', this.obligation);
      //  const d = JSON.parse(localStorage.getItem('demandeur'));
      //  this.recepisse = 'data:application/pdf;base64,' + d.recepisse;
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

  downloadFile() {
    console.log('inside function!!!');
    // download file
    this.autorisationService.getAutorisationWord(94).subscribe(
        res => {
          //  const blob = new Blob([res.blob()], { type : 'application/msword' });
          //  const file = new File([blob], this.fileName + '.doc', { type: 'application/msword' });
            console.log(res);
          //  saveAs(file);
        },
        err => {
            // notify error
            console.log('errrrreuuuuuuuuur');
            console.log(err);
        }
    );
}

}
