import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DemandeService } from '../services/demande.service';
import { AuthService } from '../services/auth.service';
import { Subscription } from 'rxjs';
import { Gestionnaire, Demandeur } from '../models/utilisateur.model';
import { User } from 'firebase';
import { SelectItem } from 'primeng/api/selectitem';

@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.scss']
})
export class DemandeComponent implements OnInit {

  demandes: any;
  sortField: string;
  sortOrder: number;
  sortKey: string;
  sortOptions: SelectItem[];

  constructor(private authservice: AuthService) { }

  ngOnInit(): void {
    this.demandes = this.authservice.getUser().demandes;
    this.sortOptions = [
      {label: 'id inc', value: 'id'},
      {label: 'id dec', value: '!id'},
      {label: 'date Demande inc', value: 'dateDemande'}
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

}
