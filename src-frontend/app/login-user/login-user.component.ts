import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { first, map } from 'rxjs/operators';
import { Gestionnaire } from '../models/gestionnaire.model';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.scss']
})
export class LoginUserComponent implements OnInit {
  signInform: FormGroup;
  errorMessage: string;
  message: any;
  gestionnaire: Gestionnaire;
  currentUser: any;

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
      this.router.navigate(['/equipements']);
      this.authservice.getGestionnaire(username).subscribe(res => {
         this.gestionnaire = res;
         console.log(this.gestionnaire);
         this.emitUserService(this.gestionnaire);
        }, err => {
          console.log(err);
        }
        );
    }, err => {
      this.errorMessage = 'uncorrect! try again';
       }
    );
    resp.pipe( map (
      result => {
        localStorage.setItem('body', result.url);
        console.log(localStorage.getItem('body'));
      }
    ));

  }
  emitUserService(g: Gestionnaire) {
    this.authservice.emitUser(g);
  }
 /* onSubmit() {
    const username = this.signInform.get('username').value;
    const password = this.signInform.get('password').value;
    this.authservice.login(username, password);
  }*/

}
