import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Equipement } from '../models/equipement.model';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EquipementsService {

  private host = 'http://localhost:8080' ;
  private jwtToken = this.authservice.loadToken();
  constructor(private http: HttpClient, private authservice: AuthService) {}


  getEquipements() {
    return this.http.get<Equipement>(this.host + '/equipements',
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
}
