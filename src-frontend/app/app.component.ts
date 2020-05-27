import { Component } from '@angular/core';
import * as firebase from 'firebase';
import { Demandeur } from './models/utilisateur.model';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  demandeur: Demandeur;
  constructor(private authservice: AuthService) {
  }
}
