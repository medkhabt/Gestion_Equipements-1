import { Component, OnInit, Output } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up-gestionnaire',
  templateUrl: './sign-up-gestionnaire.component.html',
  styleUrls: ['./sign-up-gestionnaire.component.scss']
})
export class SignUpGestionnaireComponent implements OnInit {

  signUpform: FormGroup;
  errorMessage: string;
  message: any;
  @Output() tosignin: string;
  submitted = false;

  constructor(private formbuilder: FormBuilder,
              private authservice: AuthService,
              private router: Router) { }

ngOnInit(): void {
this.initForm();
}
initForm() {
this.signUpform = this.formbuilder.group(
{
username: [ '' , [ Validators.required]],
password: [ '' , [Validators.required, Validators.minLength(6)] ],
repassword: [ '' , [Validators.required], ],
nom: [ '' , [Validators.required] ],
prenom: [ '', [Validators.required]  ],
telephone: [ '' , [Validators.required] ],
email: [ '' , [Validators.required, Validators.email] ],
type: ['', [Validators.required]]
}, {
validator: this.MustMatch('password', 'repassword')
}
);
}
get f() { return this.signUpform.controls; }
onSubmit() {
console.log(this.f.username.errors);
this.submitted = true;
if (this.signUpform.invalid) {
return;
}
const username = this.signUpform.get('username').value;
const password = this.signUpform.get('password').value;
// const repassword = this.signUpform.get('password').value;
const nom = this.signUpform.get('nom').value;
const prenom = this.signUpform.get('prenom').value;
const telephone = this.signUpform.get('telephone').value;
const email = this.signUpform.get('email').value;
const role = this.signUpform.get('type').value;
const roles = [role];
const actived = true ;

const gestionnaire = {
username, password, nom, telephone, email, actived, prenom
};


if (this.signUpform.get('type').value === 'Gestionnaire') {

  const resp = this.authservice.registerGestionnaire(gestionnaire);
  // tslint:disable-next-line: no-shadowed-variable
  resp.subscribe( resp => {
  console.log(resp);
  this.router.navigate(['/message']);
  this.tosignin = 'votre compte a été crée avec succés !';
    }, err => {
  this.errorMessage = 'Erreur !! Reéssayez à nouveau';
    }
   );
  }
if (this.signUpform.get('type').value === 'Decideur') {
  this.authservice.registerDecideur(gestionnaire).subscribe(
    resp => {
      console.log(resp);
      // this.router.navigate(['']);
      this.tosignin = 'votre compte a été crée avec succés !';
    }
  );
  }
}
onReset() {
this.submitted = false;
this.signUpform.reset();
}
// checkPasswords(signUpform: FormGroup) { // here we have the 'passwords' group
//   const pass = signUpform.get('password').value;
//   const confirmPass = signUpform.get('confirmPass').value;

//   return pass === confirmPass ? null : { notSame: true } ;
// }
// custom validator to check that two fields match
MustMatch(controlName: string, matchingControlName: string) {
return (formGroup: FormGroup) => {
const control = formGroup.controls[controlName];
const matchingControl = formGroup.controls[matchingControlName];

if (matchingControl.errors && !matchingControl.errors.mustMatch) {
// return if another validator has already found an error on the matchingControl
return;
}

// set error on matchingControl if validation fails
if (control.value !== matchingControl.value) {
matchingControl.setErrors({ mustMatch: true });
} else {
matchingControl.setErrors(null);
}
};
}

}
