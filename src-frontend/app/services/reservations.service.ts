import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  private reservations = JSON.parse(localStorage.getItem('reservations'));
  private host = 'http://localhost:8080' ;

  constructor(private http: HttpClient) { }

  getAllReservations() {
    return this.http.get(this.host + '/reservations');
  }

  getReservations() {
    return this.reservations;
  }
  addReservation(reservation: any) {
    return this.http.post(this.host + '/reservations/add', reservation);
  }
  getReservation(id: number) {
    return this.http.get(this.host + '/reservations/get/' + id);
  }
  getDemandeurByDemande(id: any) {
    return this.http.get(this.host + '/demandeurs/demande/' + id);
  }
  updateReservation(reservation: any, id: number) {
    return this.http.put(this.host + '/reservations/update/' + id , reservation);
  }
  getReservationsByDemandeur(id: any) {
    return this.http.get(this.host + '/reservations/by_demandeur/' + id);
  }
  getReservationByDemande(Iddemande: any) {
    return this.http.get(this.host + '/reservations/by_demande/' + Iddemande);
  }
}
