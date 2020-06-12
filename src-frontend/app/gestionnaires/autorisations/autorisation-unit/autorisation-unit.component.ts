import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AutorisationsService } from 'src/app/services/autorisations.service';
import { ReservationsService } from 'src/app/services/reservations.service';

@Component({
  selector: 'app-autorisation-unit',
  templateUrl: './autorisation-unit.component.html',
  styleUrls: ['./autorisation-unit.component.scss']
})
export class AutorisationUnitComponent implements OnInit {

  id: number;
  autorisation: any;
  comment: any;
  demandeur: any;
  constructor(private router: ActivatedRoute,
              private autorisationService: AutorisationsService,
              private reservationServce: ReservationsService) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.autorisationService.getAutorisationById(this.id).subscribe(
      resp => {
          this.autorisation = resp;
          this.reservationServce.getDemandeurByDemande(this.autorisation.reservation.demande.id).subscribe(
            res => {
              this.demandeur = res;
            }, err => {
              console.log(err);
            }
            );
      },
      err => {
        console.log(err);
      }
    );

    this.comment = this.autorisation.reservation.commentaire;
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
