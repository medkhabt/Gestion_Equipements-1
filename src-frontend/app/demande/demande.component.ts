import { Component, OnInit, } from '@angular/core';
import { DemandeService } from 'src/app/services/demande.service'; 
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { Demande } from '../models/demande.model';
import {DataViewModule} from 'primeng/dataview';
import {SelectItem} from 'primeng/api';
 
@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.scss']
})
export class DemandeComponent implements OnInit {
  demandes: any ; 
  sortField: string; 
  sortOrder: number; 
  sortKey: string;
  sortOptions: SelectItem[];

  constructor(private demandeService: DemandeService,
    private authservice: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    this.demandeService.getDemandes().subscribe(
      resp => {
        this.demandes = resp ;
        console.log(resp); 
      }, err => { 
        console.log(err);
    //    this.authservice.logout();
    //    this.router.navigate(['']);
      }
      
    );
    this.sortOptions = [
      {label: 'id inc', value: "id"},
      {label: 'id dec', value: "!id"},
      {label: 'date Demande inc', value: "dateDemande"}
    ];
  }

  onSortChange(event) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
        this.sortOrder = -1;
        this.sortField = value.substring(1, value.length);
    }
    else {
        this.sortOrder = 1;
        this.sortField = value;
    }
  }
}
