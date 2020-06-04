import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AutorisationsService {

  private host = 'http://localhost:8080' ;
  private jwtToken = this.authservice.loadToken();
  constructor(private http: HttpClient, private authservice: AuthService) {}

  getAutorisations() {
    return this.http.get(this.host + '/autorisations').subscribe(
      res => localStorage.setItem('autorisations', JSON.stringify(res)),
      err => console.log(err)
    );
  }
  addAutorisation(autorisation: any) {
      return this.http.post(this.host + '/autorisations/add', autorisation);
  }
}
