import { Component, OnInit } from '@angular/core';
import { Label, MultiDataSet } from 'ng2-charts';
import { ChartType } from 'chart.js';

@Component({
  selector: 'app-autorisation-pie-chart',
  templateUrl: './autorisation-pie-chart.component.html',
  styleUrls: ['./autorisation-pie-chart.component.scss']
})
export class AutorisationPieChartComponent implements OnInit {

  doughnutChartLabels: Label[];
  doughnutChartData: MultiDataSet;
  doughnutChartType: ChartType;

  constructor() { }

  ngOnInit(): void {
    this.doughnutChartLabels = ['Validée', 'rejetée', 'initial', 'en cours de traitement'];
    this.doughnutChartData = [
      [300, 90, 110, 20]
    ];
    this.doughnutChartType = 'doughnut';

  }

}
