import { Component, OnInit } from '@angular/core';
import { ChartDataSets } from 'chart.js';
import { Label, Color } from 'ng2-charts';
import { AuthService } from 'src/app/services/auth.service';
import { AutorisationsService } from 'src/app/services/autorisations.service';
import { stringify } from 'querystring';

@Component({
  selector: 'app-autorisation-chart',
  templateUrl: './autorisation-chart.component.html',
  styleUrls: ['./autorisation-chart.component.scss']
})
export class AutorisationChartComponent implements OnInit {

  autorisations: any;
  lineChartData: ChartDataSets[];
  lineChartLabels: Label[];
  lineChartColors: Color[];
  lineChartLegend = true;
  lineChartPlugins = [];
  lineChartType = 'line';
  lineChartOptions: any;
  constructor(private authService: AuthService,
              private autorisationservice: AutorisationsService) { }

  ngOnInit(): void {
    this.autorisationservice.getAutorisationsByMonth().subscribe(
      resp => {
        this.autorisations = resp;
        console.log(resp.toString());
        console.log(this.autorisations[0]);

        this.lineChartData = [
         // tslint:disable-next-line: max-line-length
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
                  this.autorisations[11],
                ], label: 'les autorisations' },
        ];

        this.lineChartLabels = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
                                'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
        this.lineChartOptions = {
         responsive: true,
          };

        this.lineChartColors = [
          {
            borderColor: 'black',
            backgroundColor: 'rgba(255,255,0,0.28)',
          },
        ];
      },
      err => console.log(err)
    );
  }

}
