import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DemandeService } from 'src/app/services/demande.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-demandes-demandeur',
  templateUrl: './demandes-demandeur.component.html',
  styleUrls: ['./demandes-demandeur.component.scss']
})
export class DemandesDemandeurComponent implements OnInit {
  barChartOptions: ChartOptions;
  barChartLabels: Label[];
  barChartType: ChartType;
  barChartLegend;
  barChartPlugins;
  barChartData: ChartDataSets[];
  demandes: any;
  demandeurs: any;
  checkDemandeur: FormGroup;


  constructor(private demandesService: DemandeService,
              private formbuilder: FormBuilder,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.demandesService.getDemandesByDemandeur(8).subscribe(
      resp => {
        this.demandes = resp;
        this.barChartOptions = {
          responsive: true,
        };
        this.barChartLabels = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
                              'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
        this.barChartType = 'bar';
        this.barChartLegend = true;
        this.barChartPlugins = [];

        this.barChartData = [
          // { data: [this.demandes[0],
          //         this.demandes[1],
          //         this.demandes[2],
          //         this.demandes[3],
          //         this.demandes[4],
          //         this.demandes[5],
          //         this.demandes[6],
          //         this.demandes[7],
          //         this.demandes[8],
          //         this.demandes[9],
          //         this.demandes[10],
          { data: [3, 0, 2, 1, 0, 0, 3, 1, 2, 0, 0, 1,
                  this.demandes[11]], label: 'demandes déposées par : Amar' }
        ];
      }
    );
    this.initForm();
    this.demandesService.getAllDemandeurs().subscribe(
      res => this.demandeurs = res,
      err => console.log(err)
    );
  }
  initForm() {
    this.checkDemandeur = this.formbuilder.group(
      {
        demandeur: [ Number , [ Validators.required]],
      }
    );
  }

  onSubmit() {
    const demandeur = this.checkDemandeur.get('demandeur').value;
    this.demandesService.getDemandesByDemandeur(demandeur).subscribe(
      resp => {
        this.demandes = resp;
        this.barChartOptions = {
          responsive: true,
        };
        this.barChartLabels = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
                              'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
        this.barChartType = 'bar';
        this.barChartLegend = true;
        this.barChartPlugins = [];

        this.barChartData = [
          { data: [this.demandes[0],
                  this.demandes[1],
                  this.demandes[2],
                  this.demandes[3],
                  this.demandes[4],
                  this.demandes[5],
                  this.demandes[6],
                  this.demandes[7],
                  this.demandes[8],
                  this.demandes[9],
                  this.demandes[10],
                  this.demandes[11]], label: 'Les demandes déposées par ce demandeur:' }
        ];
      }
    );
  }
}
