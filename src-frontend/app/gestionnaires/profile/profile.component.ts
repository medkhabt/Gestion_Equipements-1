import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  ProfileForm: FormGroup;
  gestionnaire: any;
  g: any;
  constructor(private formBuilder: FormBuilder,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.gestionnaire = JSON.parse(localStorage.getItem('gestionnaire'));

    console.log(this.gestionnaire);
    this.initForm();
  }

  initForm() {
    this.ProfileForm = this.formBuilder.group(
      {
        id: [this.gestionnaire.id, [Validators.required]],
        username: [ this.gestionnaire.username , [ Validators.required]],
        password: [this.gestionnaire.password, [Validators.required]],
        nom: [ this.gestionnaire.nom , [Validators.required] ],
        prenom: [ this.gestionnaire.prenom , [Validators.required] ],
        telephone: [ this.gestionnaire.telephone , [Validators.required] ],
        type: [ this.gestionnaire.type , [Validators.required] ],
        email: [ this.gestionnaire.email , [Validators.required] ]
      }
    );
  }

  onSubmit() {

  }


}
