import { Component, OnInit } from '@angular/core';
import { DemandeService } from 'src/app/services/demande.service';

@Component({
  selector: 'app-demandes',
  templateUrl: './demandes.component.html',
  styleUrls: ['./demandes.component.scss']
})
export class DemandesComponent implements OnInit {
  demandes: any;

  constructor(private demandeService: DemandeService) { }

  ngOnInit(): void {
    this.demandeService.getAllDemandes();
    this.demandes = this.demandeService.getDemandes();
    console.log(this.demandes);
  }

}
