import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class DemandeService {

  private host = 'http://localhost:8080' ;
  private demandes = JSON.parse(localStorage.getItem('demandes'));
  jwtToken: any;
  constructor(private http: HttpClient, private authservice: AuthService) { }

  addDemande(demande: any) {
   return this.http.post(this.host + '/demandes/add', demande);
  }

  getDemandeBydemandeur(id: any) {
    return this.http.get(this.host + '/demandeurs/demandes/' + id,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
  getAllDemandes() {
    return this.http.get(this.host + '/demandes').subscribe(
      res => localStorage.setItem('demandes', JSON.stringify(res)),
      err => console.log(err)
    );
  }
  getDemandes() {
    return this.demandes;
  }

}
