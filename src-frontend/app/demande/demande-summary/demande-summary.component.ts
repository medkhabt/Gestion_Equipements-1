import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-demande-summary',
  templateUrl: './demande-summary.component.html',
  styleUrls: ['./demande-summary.component.scss']
})
export class DemandeSummaryComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('demandeSum') demande: any;
  constructor() { }

  ngOnInit(): void {
  }

}
