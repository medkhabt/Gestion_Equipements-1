import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EquipementsService } from '../services/equipements.service';
import { Equipement } from '../models/Equipement';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-list-equipement',
  templateUrl: './list-equipement.component.html',
  styleUrls: ['./list-equipement.component.scss']
})
export class ListEquipementComponent implements OnInit {

  equipements: any ;
  sortOptions: SelectItem[] ;
  sortKey: string;
  sortField: string;
  sortOrder: number;
  selectedEquipement: any ;
  displayDialog: boolean;


  constructor(private equipementService: EquipementsService,
              private router: Router) { }

  ngOnInit(): void {
    this.equipementService.getEquipements().subscribe(
      resp => {
        this.equipements = resp ;
        console.log(resp);
      }, err => {
        console.log(err);
      }
    );

    this.sortOptions = [
        {label: 'Newest First', value: '!year'},
        {label: 'Oldest First', value: 'year'},
        {label: 'Brand', value: 'brand'}
    ];
  }

  onSortChange(event) {
    const value = event.value;

    if (value.indexOf('!') === 0) {
        this.sortOrder = -1;
        this.sortField = value.substring(1, value.length);
    } else {
        this.sortOrder = 1;
        this.sortField = value;
    }
  }

  onDialogHide() {
    this.selectedEquipement = null;
  }
  selectEquipement(event: Event, equipement: Equipement) {
    this.selectedEquipement = equipement;
    this.displayDialog = true;
    event.preventDefault();
  }

}
