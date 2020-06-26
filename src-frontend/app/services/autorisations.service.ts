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
  getAutorisationWord(id: number) {
    // tslint:disable-next-line: deprecation
    return this.ht.get(this.host + '/autorisations/get_doc/' + id, {responseType: ResponseContentType.Blob});
  }
}
