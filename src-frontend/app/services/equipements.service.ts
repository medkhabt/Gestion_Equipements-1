import { Injectable } from '@angular/core';
import {Equipement} from '../models/Equipement';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EquipementsService {

    constructor(private http: HttpClient) {}
    private host = 'http://localhost:8080' ;

    getEquipements() {
      return this.http.get(this.host + '/equipements', { responseType: 'json' });
    }
}
