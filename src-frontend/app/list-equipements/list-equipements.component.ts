import { Component, OnInit } from '@angular/core';
import { Equipement } from './equipement.model';

@Component({
  selector: 'app-list-equipements',
  templateUrl: './list-equipements.component.html',
  styleUrls: ['./list-equipements.component.css']
})
export class ListEquipementsComponent implements OnInit {
  equipements: Equipement[] = [
                                  new Equipement(123,"wut",32,"somewhere", 32,21), 
                                  new Equipement(134,"WASSSAP",32,"idk", 32,21)
                                ]; 
  equipementSelected: Equipement; 
  constructor() { }

  // public id: Number,
  // public nom: string,
  // public  idResponsable: Number,
  // public  adresse: string,
  // public largeur: Number,
  // public longueur: Number
  ngOnInit(): void {
  }



}
