import { Component, OnInit } from '@angular/core';
import { EquipementsService } from 'src/app/services/equipements.service';
import { AuthService } from 'src/app/services/auth.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-equipement-update',
  templateUrl: './equipement-update.component.html',
  styleUrls: ['./equipement-update.component.scss']
})
export class EquipementUpdateComponent implements OnInit {

  equipement: any;
  id: number;
  updateForm: FormGroup;
  secteur: any;
  constructor(private equipementService: EquipementsService,
              public authservice: AuthService,
              private router: ActivatedRoute,
              private formbuilder: FormBuilder) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params.id;
    this.equipementService.getEquipement(this.id).subscribe(
      res => {
        this.equipement = res;
        this.equipementService.getSecteurByEquipement(this.id).subscribe(
          resp => {this.secteur = resp;
                   this.initForm();
                }
        );
      },
      err => console.log(err)
    );

  }

  initForm() {
    this.updateForm = this.formbuilder.group(
      {
        idResponsable: [this.equipement.idResponsable, [Validators.required]],
        nom: [ this.equipement.nom , [ Validators.required]],
        adresse: [this.equipement.adresse, [Validators.required]],
        largeur: [ this.equipement.largeur , [Validators.required] ],
        longueur: [ this.equipement.longueur , [Validators.required] ],
        secteur: [ this.secteur, [Validators.required] ],
        etat: [this.equipement.etat, [Validators.required]]
      }
    );
  }

  onSubmit() {
    console.log(this.updateForm.value);
    this.equipementService.updateEquipement(this.id, this.updateForm.value).subscribe(
      resp => console.log(resp),
      err => console.log(err)
    );
  }

}
