import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-demande-unit',
  templateUrl: './demande-unit.component.html',
  styleUrls: ['./demande-unit.component.css']
})
export class DemandeUnitComponent implements OnInit {
  @Input('demandeUnit')  demande: any; 
  constructor() { }

  ngOnInit(): void {
  }

}
