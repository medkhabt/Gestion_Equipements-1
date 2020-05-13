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
    return this.http.get(this.host + '/reservations').subscribe(
      res => localStorage.setItem('reservations', JSON.stringify(res)),
      err => console.log(err)
    );
  }

  getReservations() {
    return this.reservations;
  }
}
