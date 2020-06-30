import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  private reservations = JSON.parse(localStorage.getItem('reservations'));
  private host = 'http://localhost:8080' ;
  jwtToken = localStorage.getItem('token');
  constructor(private http: HttpClient) { }

  getAllReservations() {
    return this.http.get(this.host + '/reservations',
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }

  getReservations() {
    return this.reservations;
  }
  addReservation(reservation: any) {
    return this.http.post(this.host + '/reservations/add', reservation,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
  getReservation(id: number) {
    return this.http.get(this.host + '/reservations/get/' + id,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
  getDemandeurByDemande(id: any) {
    return this.http.get(this.host + '/demandeurs/demande/' + id);
  }
  updateReservation(reservation: any, id: number) {
    return this.http.put(this.host + '/reservations/update/' + id , reservation,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
  getReservationsByDemandeur(id: any) {
    console.log(this.jwtToken);
    return this.http.get(this.host + '/reservations/by_demandeur/' + id,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
  getReservationByDemande(Iddemande: any) {
    return this.http.get(this.host + '/reservations/by_demande/' + Iddemande,
    {headers: new HttpHeaders({authorization: this.jwtToken})});
  }
}
