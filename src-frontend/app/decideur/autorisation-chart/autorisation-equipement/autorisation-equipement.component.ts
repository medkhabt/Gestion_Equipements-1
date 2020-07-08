import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { AutorisationsService } from 'src/app/services/autorisations.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipementsService } from 'src/app/services/equipements.service';

@Component({
  selector: 'app-autorisation-equipement',
  templateUrl: './autorisation-equipement.component.html',
  styleUrls: ['./autorisation-equipement.component.scss']
})
export class AutorisationEquipementComponent implements OnInit {

  barChartOptions: ChartOptions;
  barChartLabels: Label[];
  barChartType: ChartType;
  barChartLegend;
  barChartPlugins;
  barChartData: ChartDataSets[];
  autorisations: any;
  equipements: any;
  checkEquipement: FormGroup;


  constructor(private autorisationService: AutorisationsService,
              private formbuilder: FormBuilder,
              private equipementService: EquipementsService) { }

  ngOnInit(): void {
    this.autorisationService.getAutorisationsByEquipement('agadir').subscribe(
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
                  this.autorisations[11]],
            label: 'Autorisations en equipement : Agadir',
             }
        ];
      }
    );
    this.initForm();
    this.equipementService.getEquipements().subscribe(
      resp => {
        this.equipements = resp;
      }
    );
  }

  initForm() {
    this.checkEquipement = this.formbuilder.group(
      {
        equipement: [ '' , [ Validators.required]],
      }
    );
  }
  onSubmit() {
    const equipement = this.checkEquipement.get('equipement').value;
    this.autorisationService.getAutorisationsByEquipement(equipement).subscribe(
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
                  this.autorisations[11]], label: 'Autorisations en equipement:' + equipement }
        ];
      }
    );
  }

}
