import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Equipement } from '../models/equipement.model';

@Injectable({
  providedIn: 'root'
})
export class EquipementsService {

    constructor(private http: HttpClient) {}
    private host = 'http://localhost:8080' ;

    getEquipements() {
      return this.http.get<Equipement>(this.host + '/equipements');
    }
}
