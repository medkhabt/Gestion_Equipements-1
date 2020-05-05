import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-equipement',
  templateUrl: './equipement.component.html',
  styleUrls: ['./equipement.component.scss']
})
export class EquipementComponent implements OnInit {

  nom: string;
  // tslint:disable-next-line: variable-name
  id_responsable: any;
  adresse: string;
  largeur: number;
  longueur: number;

  constructor() { }

  ngOnInit(): void {
  }

}
