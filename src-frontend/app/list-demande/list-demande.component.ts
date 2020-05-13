import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-list-demande',
  templateUrl: './list-demande.component.html',
  styleUrls: ['./list-demande.component.scss']
})
export class ListDemandeComponent implements OnInit {
  demandes: any;

  constructor(private authservice: AuthService) { }

  ngOnInit(): void {
    this.demandes = this.authservice.getUser().demandes;
  }
  fetch() {
    console.log(this.demandes);
  }


}
