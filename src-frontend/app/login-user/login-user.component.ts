import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { first, map } from 'rxjs/operators';
import { Gestionnaire, Demandeur } from '../models/utilisateur.model';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.scss']
})
export class LoginUserComponent implements OnInit {
  signInform: FormGroup;
  errorMessage: string;
  message: any;
  demandeur: any;
  currentUser: any;
  role: void;

  constructor(private formbuilder: FormBuilder,
              private authservice: AuthService,
              private router: Router) {
               }


  ngOnInit(): void {
    this.initForm();
  }
  initForm() {
    this.signInform = this.formbuilder.group(
      {
        username: [ '' , [ Validators.required]],
        password: [ '' , [Validators.required] ]
      }
    );
  }
  onSubmit() {
    const username = this.signInform.get('username').value;
    const password = this.signInform.get('password').value;
    const resp = this.authservice.login(username, password);
    // tslint:disable-next-line: no-shadowed-variable
    resp.subscribe( resp => {
      const jwtToken = resp.headers.get('authorization');
      this.authservice.saveToken(jwtToken);
      this.authservice.getDemandeur(username).subscribe(res => {
         this.demandeur = res;
         console.log(this.demandeur);
         localStorage.setItem('demandeur', JSON.stringify(res));
         localStorage.setItem('etat', res.roles[0].role);

        }, err => {
          console.log(err);
        }
        );
      this.router.navigate(['/equipements']);
    }, err => {
      this.errorMessage = 'uncorrect! try again';
       }
    );

  }

 /* onSubmit() {
    const username = this.signInform.get('username').value;
    const password = this.signInform.get('password').value;
    this.authservice.login(username, password);
  }*/

}
