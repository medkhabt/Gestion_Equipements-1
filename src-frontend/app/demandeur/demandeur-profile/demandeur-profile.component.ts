import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-demandeur-profile',
  templateUrl: './demandeur-profile.component.html',
  styleUrls: ['./demandeur-profile.component.scss']
})
export class DemandeurProfileComponent implements OnInit {

  ProfileForm: FormGroup;
  recepisse: any;
  demandeur: any;
  statut: any;
  profileImage: any;
  retreivedRecepisse: any;
  constructor(private formBuilder: FormBuilder,
              private authService: AuthService) { }

  ngOnInit(): void {
    const d: any = JSON.parse(localStorage.getItem('demandeur'));
    const id = d.id;
    this.authService.getDemandeurById(id).subscribe(
      resp => {
        this.demandeur = resp;
        this.retreivedRecepisse = 'data:image/jpeg;base64,' + this.demandeur.imageProfile;
        this.recepisse = 'data:image/jpeg;base64,' + this.demandeur.recepisse;
        this.statut = 'data:image/jpeg;base64,' + this.demandeur.statut;
        this.profileImage = 'data:image/jpeg;base64,' + this.demandeur.imageProfile;
        this.initForm();
      },
      err => console.log(err)
    );


  }
  initForm() {
    this.ProfileForm = this.formBuilder.group(
      {
        id: [this.demandeur.id, [Validators.required]],
        username: [ this.demandeur.username , [ Validators.required]],
        password: [this.demandeur.password, [Validators.required]],
        nom: [ this.demandeur.nom , [Validators.required] ],
        prenom: [ this.demandeur.prenom , [Validators.required] ],
        telephone: [ this.demandeur.telephone , [Validators.required] ],
        type: [ this.demandeur.type , [Validators.required] ],
        email: [ this.demandeur.email , [Validators.required] ],
        adresse: [ this.demandeur.adresse , [Validators.required]]
      }
    );
  }

  saveRecepisse(event) {
    this.recepisse = event.target.files[0];
    console.log(this.recepisse);
  }
  saveStatut(event) {
    this.statut = event.target.files[0];
  }
  saveProfileImage(event) {
    this.profileImage = event.target.files[0];
  }

  onSubmit() {
    let demandeur: any;
    const ProfileForm = this.ProfileForm.getRawValue();
    const recepisse = this.recepisse;
    const statut = this.statut;
    const imageProfile = this.profileImage;
    demandeur = {
      ProfileForm,
    };
    console.log(demandeur);
    this.authService.updateDemandeur(this.ProfileForm.value, this.demandeur.id).subscribe(
      resp => {
        console.log(resp);
      }, err => console.log(err)
    );


    const uploadImageData = new FormData();
    uploadImageData.append('recepisse', this.recepisse, this.recepisse.name);
    uploadImageData.append('statut', this.statut, this.statut.name);
    uploadImageData.append('profileImage', this.profileImage, this.profileImage.name);
    this.authService.sendFile(uploadImageData, this.demandeur.id).subscribe(
      res =>  console.log(res)
      , err => console.log(err)
    );
  }
  afficher() {
    console.log(this.recepisse);
    // console.log(this.statut);

  }

}
