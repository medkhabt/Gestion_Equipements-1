import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {JwtHelper} from 'angular2-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient ) { }

  private host = 'http://localhost:8080' ;
  private jwtToken: string;
  private roles: Array<any> = [];

  login(username: string, password: string) {
  return this.http.post(this.host + '/login',
           {username, password},
           { observe: 'response' }
            );
  }
  register(demandeur: any) {

  return this.http.post(this.host + '/demandeurs/register', demandeur);

  }
  getDemandeurs() {
    if (this.jwtToken === null) {this.loadToken(); }
    return this.http.get(this.host + '/demandeurs',
    {headers: new HttpHeaders({authorization: this.jwtToken})});
    }


  saveToken(jwtToken) {

  this.jwtToken = jwtToken;
  localStorage.setItem('token', jwtToken);
  const jwtHelper = new JwtHelper();
  this.roles = jwtHelper.decodeToken(this.jwtToken).roles;
  }
  loadToken() {
    this.jwtToken = localStorage.getItem('token');
    return this.jwtToken;
    }

  logout() {
    localStorage.removeItem('token');
    }
/*
  isAdmin() {
    for (const role: any of this.roles ) {
    if (role.authority === 'ADMIN') {return true; }
    }
    return false;
    }*/

}
