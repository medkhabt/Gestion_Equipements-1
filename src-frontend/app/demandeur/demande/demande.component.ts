import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DemandeService } from '../../services/demande.service';
import { AuthService } from '../../services/auth.service';
import { Subscription } from 'rxjs';
import { Gestionnaire, Demandeur } from '../../models/utilisateur.model';
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
  id: number;

  constructor(private authservice: AuthService,
              private demandeService: DemandeService) { }

  ngOnInit(): void {
    this.id = this.authservice.getUser().id;
    this.demandeService.getDemandeBydemandeur(this.id).subscribe(
      rep => this.demandes = rep,
      err => console.log(err)
    );
    console.log(this.demandes);
    this.sortOptions = [
      {label: 'id inc', value: 'id'},
      {label: 'id dec', value: '!id'},
      {label: 'date Demande inc', value: 'dateDemande'}
    ];
  }

  formatDate(date) {
        const d = new Date(date);
        let month = '' + (d.getMonth() + 1);
        let day = '' + d.getDate();
        const year = d.getFullYear();

        if (month.length < 2) {
        month = '0' + month;
        }
        if (day.length < 2) {
        day = '0' + day;
        }

        return [year, month, day].join('-');
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
