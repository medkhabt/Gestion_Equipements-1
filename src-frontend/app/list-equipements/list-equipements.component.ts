import { Component, OnInit } from '@angular/core';
import { Equipement } from 'src/app/models/equipement.model';
import { EquipementsService } from '../services/equipements.service';

@Component({
  selector: 'app-list-equipements',
  templateUrl: './list-equipements.component.html',
  styleUrls: ['./list-equipements.component.css']
})
export class ListEquipementsComponent implements OnInit {
  equipements: Equipement ;
  equipementSelected: Equipement;
  constructor(private equipementService: EquipementsService) { }

  // public id: Number,
  // public nom: string,
  // public  idResponsable: Number,
  // public  adresse: string,
  // public largeur: Number,
  // public longueur: Number
  ngOnInit(): void {
  this.equipementService.getEquipements().subscribe(
    resp => {
      this.equipements = resp ;
      console.log(resp);
    }, err => {
      console.log(err);
    }
  );
  }

}
