import { HttpClient, HttpHeaders, HttpErrorResponse} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {JwtHelper} from 'angular2-jwt';
import { JwtHelperService } from '@auth0/angular-jwt';
import { map, catchError } from 'rxjs/operators';
import { Equipement } from '../models/equipement.model';
import { BehaviorSubject, Observable, throwError, Subject } from 'rxjs';
import { Gestionnaire } from '../models/gestionnaire.model';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private host = 'http://localhost:8080' ;
  private jwtToken: string;
  roles: Array<any> = [];
  public currentUserSubject = new Subject<any>();
  public currentUser: Observable<any>; 
  g: any;

  constructor(private http: HttpClient,
              private router: Router) {
   }

  login(username: string, password: string) {
  return this.http.post<any>(this.host + '/login',
           {username, password},
           { observe: 'response' });
  }
  register(demandeur: any) {

  return this.http.post(this.host + '/demandeurs/register', demandeur);

  }
  emitUser(g: Gestionnaire) {
    this.currentUserSubject.next(g);
    console.log(g);
  }
  // User profile
  getUserProfile(id): Observable<any> {
    const api = this.host + '/gestionnaires/' + id ;
    return this.http.get(this.host + '/gestionnaires/' + id,
                         {headers: new HttpHeaders({authorization: this.jwtToken})})
    .pipe(
      map((res: Response) => {
        return res || {};
      }),
      catchError(this.handleError)
    );
  }
  // Error
  handleError(error: HttpErrorResponse) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      msg = error.error.message;
    } else {
      // server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(msg);
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
  this.g = jwtHelper.decodeToken(this.jwtToken).id ;
  }
  loadToken() {
    this.jwtToken = localStorage.getItem('token');
    return this.jwtToken;
    }

  logout() {
    localStorage.removeItem('token');
    }
  getEquipements() {
      return this.http.get<Equipement>(this.host + '/equipements',
      {headers: new HttpHeaders({authorization: this.jwtToken})});
    }
  getGestionnaire(username: any) {
    return this.http.get<Gestionnaire>(this.host + '/gestionnaires/' + username,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }

  get isLoggedIn(): boolean {
    const authToken = localStorage.getItem('token');
    const islogged = (authToken !== null) ? true : false;
   // this.loggedIn.next(islogged);
    return islogged;
  }
  isloggedIn(): boolean {
    return this.isLoggedIn;
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
