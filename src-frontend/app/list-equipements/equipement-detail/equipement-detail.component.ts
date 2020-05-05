import { Component, OnInit, Input } from '@angular/core';
import { Equipement } from '../equipement.model';

@Component({
  selector: 'app-equipement-detail',
  templateUrl: './equipement-detail.component.html',
  styleUrls: ['./equipement-detail.component.css']
})
export class EquipementDetailComponent implements OnInit {
  @Input()  equipement: Equipement; 
  constructor() { }

  ngOnInit(): void {
  }

}
