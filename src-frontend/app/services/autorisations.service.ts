import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';
import { ResponseContentType } from '@angular/http';
import { Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class AutorisationsService {

  private host = 'http://localhost:8080' ;
  private jwtToken = this.authservice.loadToken();
  constructor(private http: HttpClient,
              private authservice: AuthService,
              private ht: Http) {}

  getAutorisations() {
    return this.http.get(this.host + '/autorisations');
  }
  addAutorisation(autorisation: any) {
      return this.http.post(this.host + '/autorisations/add', autorisation);
  }

  getAutorisationById(id: any) {
    return this.http.get(this.host + '/autorisations/get/' + id);
  }
  getAutorisationWord() {
    return this.http.get(this.host + '/autorisations/get_doc/94');
  }
  getAutorisationsByMonth() {
    return this.http.get(this.host + '/autorisations/par_mois/');
  }
  getAutorisationsByEquipement(nom: any) {
    return this.http.get(this.host + '/autorisations/par_equipement/' + nom);
  }
  getAutorisationsByGestionnaire(id: number) {
    return this.http.get(this.host + '/autorisations/par_gestionnaire/' + id);
  }
  getAllGestionnaires() {
    return this.http.get(this.host + '/gestionnaires');
  }
}
