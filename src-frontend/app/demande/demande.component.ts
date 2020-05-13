import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DemandeService } from '../services/demande.service';
import { AuthService } from '../services/auth.service';
import { Subscription } from 'rxjs';
import { Gestionnaire, Demandeur } from '../models/utilisateur.model';
import { User } from 'firebase';

@Component({
  selector: 'app-demande',
  templateUrl: './demande.component.html',
  styleUrls: ['./demande.component.scss']
})
export class DemandeComponent implements OnInit {

  demandeForm: FormGroup;
  errorMessage: string;
  message: any;
  user: Demandeur;
  userSubjection: Subscription;
  username: string;
  id: number;
  constructor(private formbuilder: FormBuilder,
              private router: Router,
              private demandeSrevice: DemandeService,
              private authService: AuthService) { }

  ngOnInit() {
    this.user = this.authService.getUser();
    console.log(this.user);
    this.initForm();
  }

  initForm() {
    this.demandeForm = this.formbuilder.group({
      typeEvent: [ '' , [Validators.required] ],
      dateReservation: ['', [Validators.required]],
      objet: ['', [Validators.required]],
      equipement: ['', [Validators.required]],
      nombrePresent: ['', [Validators.required]],
      description: ['', [Validators.required]],
      demandeur: [this.user],
      dateDemande: [new Date()]
    });
  }
  onSubmit() {
    const demandeur = this.user;
//  const form = this.demandeForm.value;
    console.log(this.demandeForm.get('demandeur'));
    this.demandeSrevice.addDemande(this.demandeForm.value).subscribe(
      resp => {
        console.log(resp);
      }, err => {
        console.log(err);
      }
    );


  }

}
