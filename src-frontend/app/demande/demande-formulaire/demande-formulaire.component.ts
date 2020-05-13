
import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DemandeService } from '../../services/demande.service';
import { AuthService } from '../../services/auth.service';
import { Subscription } from 'rxjs';
import { Gestionnaire } from '../../models/gestionnaire.model';
import { Equipement } from 'src/app/models/equipement.model';
import { EquipementsService } from 'src/app/services/equipements.service';
@Component({
  selector: 'app-demande-formulaire',
  templateUrl: './demande-formulaire.component.html',
  styleUrls: ['./demande-formulaire.component.css']
})
export class DemandeFormulaireComponent implements OnInit {

 

  demandeForm: FormGroup;
  errorMessage: string;
  message: any;
  user: {};
  userSubjection: Subscription;
  constructor(private formbuilder: FormBuilder,
              private router: Router,
              private demandeSrevice: DemandeService,
              private equipementsService: EquipementsService, 
              private authService: AuthService) { }

  ngOnInit(): void {
    this.initForm();
    this.userSubjection = this.authService.currentUserSubject.subscribe(
      user => {
        this.user = user;
        console.log(user);
      }
    );
  }

  initForm() {
    this.demandeForm = this.formbuilder.group({
      demandeurId: [''],
      username: [''],
      typeEvent: [ '' , [Validators.required] ],
      dateReservation: ['', [Validators.required]],
      objet: ['', [Validators.required]],
      equipement: ['', [Validators.required]],
      nombreInvite: ['', Validators.required],
      comment: ['', Validators.required]
    });
  }
  onSubmit() {
    const typeEvent = this.demandeForm.get('typeEvent').value;
    const dateReservation = this.demandeForm.get('dateReservation').value;
    const objet = this.demandeForm.get('objet').value;
    const equipement = this.demandeForm.get('equipement').value;
    const nombrePresent = this.demandeForm.get('nombreInvite').value;
    const dateDemande = new Date();
    const description = this.demandeForm.get('comment').value;
    const demande = {
      typeEvent, dateReservation, objet, equipement, nombrePresent, dateDemande, description
    };
    this.demandeSrevice.addDemande(demande).subscribe(
      resp => {
        console.log(resp);
      }, err => {
        console.log(err);
      }
    );


  }

}
