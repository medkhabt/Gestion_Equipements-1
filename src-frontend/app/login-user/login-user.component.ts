import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.scss']
})
export class LoginUserComponent implements OnInit {
  signInform: FormGroup;
  errorMessage: string;
  message: any;

  constructor(private formbuilder: FormBuilder,
              private authservice: AuthService,
              private router: Router) { }


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
      console.log(resp.headers.get('authorization'));
    }, err => {
      this.errorMessage = 'uncorrect! try again';
       }
    );
}
}
