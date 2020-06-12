import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-demandeur-unit',
  templateUrl: './demandeur-unit.component.html',
  styleUrls: ['./demandeur-unit.component.scss']
})
export class DemandeurUnitComponent implements OnInit {
  id: any;
  demandeur: any;
  demandes: any;
  recepisse: any;
  newBlob: Blob;
  statut: string;
  constructor(private router: ActivatedRoute,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.authService.getDemandeurById(this.id).subscribe(
      resp => {
        this.demandeur = resp;
        console.log(resp);
        this.demandes = this.demandeur.demandes;
        console.log(this.demandes);
        this.recepisse = 'data:application/pdf;base64,' + this.demandeur.recepisse;
        this.statut = 'data:application/pdf;base64,' + this.demandeur.statut;
        localStorage.setItem('recepisse', this.recepisse);
        localStorage.setItem('statut', this.statut);
      }, err => console.log(err)
    );

/*    this.authService.getRecepisse(this.id).subscribe(
      res => {
      }
    );*/

  }


}
