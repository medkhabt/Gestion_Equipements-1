import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipementsService } from 'src/app/services/equipements.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-equipement-create',
  templateUrl: './equipement-create.component.html',
  styleUrls: ['./equipement-create.component.scss']
})
export class EquipementCreateComponent implements OnInit {
  createForm: FormGroup;
  secteurs: any;

  constructor(private formbuilder: FormBuilder,
              private equipementservice: EquipementsService,
              public authservice: AuthService) { }

  ngOnInit(): void {
    this.equipementservice.getSecteurs().subscribe(
      resp => {
        this.secteurs = resp;
        this.initForm();
      },
      err => console.log(err)
    );
  }

  initForm() {
    this.createForm = this.formbuilder.group(
      {
        idResponsable: ['', [Validators.required]],
        nom: [ '' , [ Validators.required]],
        adresse: ['', [Validators.required]],
        largeur: [ '' , [Validators.required] ],
        longueur: [ '' , [Validators.required] ],
        secteur: [ null, [Validators.required] ],
        etat: ['maintenu', [Validators.required]]
      }
    );
  }

  onSubmit() {
    console.log(this.createForm.value);
    this.equipementservice.getSecteur(this.createForm.get('secteur').value).subscribe(
      res => {
        this.createForm.get('secteur').setValue(res);
        this.equipementservice.addEquipement(this.createForm.value).subscribe(
          resp => console.log(resp),
          err => console.log(err)
        );
      }, err => console.log(err)
    );
      }


}
