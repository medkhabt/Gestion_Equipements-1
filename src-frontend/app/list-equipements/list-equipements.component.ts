import { Component, OnInit } from '@angular/core';
import { Equipement } from 'src/app/models/equipement.model';
import { EquipementsService } from '../services/equipements.service';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-equipements',
  templateUrl: './list-equipements.component.html',
  styleUrls: ['./list-equipements.component.scss']
})
export class ListEquipementsComponent implements OnInit {
  equipements: Equipement ;
  equipementSelected: Equipement;
  constructor(private equipementService: EquipementsService,
              private authservice: AuthService,
              private router: Router) { }

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
  //    this.authservice.logout();
  //    this.router.navigate(['']);
    }
  );
  }

}
