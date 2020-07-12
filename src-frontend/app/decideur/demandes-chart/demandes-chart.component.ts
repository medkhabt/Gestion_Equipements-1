import { Component, OnInit } from '@angular/core';
import { ChartDataSets } from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { AuthService } from 'src/app/services/auth.service';
import { DemandeService } from 'src/app/services/demande.service';

@Component({
  selector: 'app-demandes-chart',
  templateUrl: './demandes-chart.component.html',
  styleUrls: ['./demandes-chart.component.scss']
})
export class DemandesChartComponent implements OnInit {

  demandes: any;
  lineChartData: ChartDataSets[];
  lineChartLabels: Label[];
  lineChartColors: Color[];
  lineChartLegend = true;
  lineChartPlugins = [];
  lineChartType = 'line';
  lineChartOptions: any;
  constructor(private authService: AuthService,
              private demandeService: DemandeService) { }

  ngOnInit(): void {
    this.demandeService.getDemandesByMonth().subscribe(
      resp => {
        this.demandes = resp;
        console.log(resp.toString());
        console.log(this.demandes[0]);

        this.lineChartData = [
         // tslint:disable-next-line: max-line-length
        //  { data: [this.demandes[0],
        //           this.demandes[1],
        //           this.demandes[2],
        //           this.demandes[3],
        //           this.demandes[4],
        //           this.demandes[5],
        //           this.demandes[6],
        //           this.demandes[7],
        //           this.demandes[8],
        //           this.demandes[9],
        //           this.demandes[10],
        //           this.demandes[11],
        { data: [11, 30, 40, 40, 80, 40, 50, 60, 80, 30, 70, 110
                ], label: 'les demandes' },
        ];

        this.lineChartLabels = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
                                'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
        this.lineChartOptions = {
         responsive: true,
          };

        this.lineChartColors = [
            {
              borderColor: '#0477BF',
              backgroundColor: '#8FBDD9',
            },
          ];
      },
      err => console.log(err)
    );
  }

}
