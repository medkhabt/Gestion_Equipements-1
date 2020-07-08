import { HttpClient, HttpHeaders, HttpErrorResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {JwtHelper} from 'angular2-jwt';
import { JwtHelperService } from '@auth0/angular-jwt';
import { map, catchError } from 'rxjs/operators';
import { Equipement } from '../models/equipement.model';
import { BehaviorSubject, Observable, throwError, Subject } from 'rxjs';
import { Gestionnaire, Demandeur } from '../models/utilisateur.model';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private host = 'http://localhost:8080' ;
  private jwtToken: string;
  // public role = localStorage.getItem('etat');
  private role: any = localStorage.getItem('etat');
  public currentUserSubject = new Subject<Demandeur>();
  public currentUser: Observable<Demandeur>;
  g: any;
  // private user: Demandeur = JSON.parse(localStorage.getItem('demandeur'));
  private user: any = JSON.parse(localStorage.getItem('demandeur'));

  constructor(private http: HttpClient,
              private router: Router) {
   }

  getRole() { return this.role; }
  setRole(role: any) {
    this.role = role;
    console.log(role);
  }

  login(username: string, password: string) {
  return this.http.post<any>(this.host + '/login',
           {username, password},
           { observe: 'response' });
  }

  register(demandeur: any) {
  return this.http.post(this.host + '/demandeurs/register', demandeur);
  }
  registerGestionnaire(gestionnaire: any) {
    return this.http.post(this.host + '/gestionnaires/register', gestionnaire);
  }
  registerDecideur(decideur: any) {
    return this.http.post(this.host + '/decideur/register', decideur);
  }
  logout() {
    localStorage.clear();
  }

  getUser() {
    return this.user;
  }
  setUser(user: any) {
    this.user = user;
  }
  isDemandeur() {
    if (this.role === 'Demandeur' && this.isloggedIn() === true) {
      return true; }
  }
  isGestionnaire() {
    if (this.role === 'Admin' && this.isloggedIn() === true) {
    return true;
    }
  }
  isDecideur() {
    if (this.role === 'Décideur' && this.isloggedIn() === true) {
      return true;
      }
  }

  getDemandeurs() {
    if (this.jwtToken === null) {this.loadToken(); }
    return this.http.get(this.host + '/demandeurs'
  //  ,{headers: new HttpHeaders({authorization: this.jwtToken})}
  );
    }
  getDecideur(username: any) {
    return this.http.get(this.host + '/decideur/' + username);
  }

  saveToken(jwtToken) {
  this.jwtToken = jwtToken;
  localStorage.setItem('token', jwtToken);
  const jwtHelper = new JwtHelper();
//  this.role = jwtHelper.decodeToken(this.jwtToken).roles[0];
// this.g = jwtHelper.decodeToken(this.jwtToken).sub ;
  console.log(this.role);
  }

  loadToken() {
    this.jwtToken = localStorage.getItem('token');
    return this.jwtToken;
    }

  getEquipements() {
      return this.http.get<Equipement>(this.host + '/equipements',
      {headers: new HttpHeaders({authorization: this.jwtToken})});
    }

  getDemandeur(username: any) {
    return this.http.get<Demandeur>(this.host + '/demandeurs/' + username,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
  getDemandeurById(id: any) {
    return this.http.get(this.host + '/demandeurs/get_id/' + id
  //  , {headers: new HttpHeaders({authorization: this.jwtToken})}
  );
  }
  updateDemandeur(demandeur: any, id: any) {
    return this.http.put(this.host + '/demandeurs/update/' + id, demandeur);
  }
  updateGestionnaire(gestionnaire, id) {
    return this.http.put(this.host + '/gestionnaires/update/' + id, gestionnaire);
  }
  sendFile(file: any, id: any) {
    return this.http.put(this.host + '/demandeurs/update_files/' + id, file);
  }
  getFiles(id: any) {
    return this.http.get(this.host + '/demandeurs/files/' + id);
  }
  getRecepisse(id: any) {
    return this.http.get(this.host + '/demandeurs/files/recepisse/' + id);
  }
  getGestionnaire(username: any) {
    return this.http.get<Demandeur>(this.host + '/gestionnaires/' + username,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }

  isloggedIn(): boolean {
    const authToken = localStorage.getItem('token');
    const islogged = (authToken !== null) ? true : false;
   // this.loggedIn.next(islogged);
    return islogged;
  }

//  isAuthenticated(): boolean {
//    return !this.jwtHelper.isTokenExpired(this.jwtToken);
//  }
/*
  isAdmin() {
    for (const role: any of this.roles ) {
    if (role.authority === 'ADMIN') {return true; }
    }
    return false;
    }*/

}
