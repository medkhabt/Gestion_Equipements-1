import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AutorisationsService } from 'src/app/services/autorisations.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-autorisation-gestionnaire',
  templateUrl: './autorisation-gestionnaire.component.html',
  styleUrls: ['./autorisation-gestionnaire.component.scss']
})
export class AutorisationGestionnaireComponent implements OnInit {
  barChartOptions: ChartOptions;
  barChartLabels: Label[];
  barChartType: ChartType;
  barChartLegend;
  barChartPlugins;
  barChartData: ChartDataSets[];
  autorisations: any;
  gestionnaires: any;
  checkGestionnaire: FormGroup;


  constructor(private autorisationService: AutorisationsService,
              private formbuilder: FormBuilder,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.autorisationService.getAutorisationsByGestionnaire(2).subscribe(
      resp => {
        this.autorisations = resp;
        this.barChartOptions = {
          responsive: true,
        };
        this.barChartLabels = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
                              'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
        this.barChartType = 'bar';
        this.barChartLegend = true;
        this.barChartPlugins = [];

        this.barChartData = [
          { data: [this.autorisations[0],
                  this.autorisations[1],
                  this.autorisations[2],
                  this.autorisations[3],
                  this.autorisations[4],
                  this.autorisations[5],
                  this.autorisations[6],
                  this.autorisations[7],
                  this.autorisations[8],
                  this.autorisations[9],
                  this.autorisations[10],
                  this.autorisations[11]], label: 'Autorisations traitées par: Akhachkhouch' }
        ];
      }
    );
    this.initForm();
    this.autorisationService.getAllGestionnaires().subscribe(
      res => this.gestionnaires = res,
      err => console.log(err)
    );
  }

  initForm() {
    this.checkGestionnaire = this.formbuilder.group(
      {
        gestionnaire: [ Number , [ Validators.required]],
      }
    );
  }
  onSubmit() {
    const gestionnaire = this.checkGestionnaire.get('gestionnaire').value;
    this.autorisationService.getAutorisationsByGestionnaire(gestionnaire).subscribe(
      resp => {
        this.autorisations = resp;
        this.barChartOptions = {
          responsive: true,
        };
        this.barChartLabels = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
                              'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
        this.barChartType = 'bar';
        this.barChartLegend = true;
        this.barChartPlugins = [];

        this.barChartData = [
          { data: [this.autorisations[0],
                  this.autorisations[1],
                  this.autorisations[2],
                  this.autorisations[3],
                  this.autorisations[4],
                  this.autorisations[5],
                  this.autorisations[6],
                  this.autorisations[7],
                  this.autorisations[8],
                  this.autorisations[9],
                  this.autorisations[10],
                  this.autorisations[11]], label: 'Les autorisations traitées par ce gestionnaire :' }
        ];
      }
    );
  }


}
