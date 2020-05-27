import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-demande-unit',
  templateUrl: './demande-unit.component.html',
  styleUrls: ['./demande-unit.component.scss']
})
export class DemandeUnitComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('demandeUnit') demande: any;
  constructor() { }

  ngOnInit(): void {
  }


}
