import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Demande } from '../models/demande.model';

@Injectable({
  providedIn: 'root'
})
export class DemandeService {

  private host = 'http://localhost:8080' ;
  constructor(private http: HttpClient) { }

  addDemande(demande: any) {
   return this.http.post(this.host + '/demandes/add', demande);
  }

  getDemandes(){
    return this.http.get<any>(this.host + '/demandes')
  }
}
