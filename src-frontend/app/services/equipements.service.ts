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
    return this.http.get<Equipement>(this.host + '/equipements');
   // {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
  getEquipement(id: number) {
    return this.http.get<Equipement>(this.host + '/equipements/get_id/' + id);
  }
  updateEquipement(id: number, equipement: any) {
    return this.http.put(this.host + '/equipements/update/' + id, equipement);
  }
  getSecteurByEquipement(id) {
    return this.http.get(this.host + '/secteurs/get_equipement/' + id);
  }
  getSecteurs() {
    return this.http.get(this.host + '/secteurs');
  }
  getSecteur(id) {
    return this.http.get(this.host + '/secteurs/get/' + id);
  }
  addEquipement(equipement ) {
    return this.http.post(this.host + '/equipements/add', equipement);
  }
}
