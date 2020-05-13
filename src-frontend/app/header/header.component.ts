import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  etat: boolean;
  constructor(public authservice: AuthService,
              private router: Router) { }

  ngOnInit(): void {
    this.authservice.role = localStorage.getItem('etat');
  }

  onLogout() {
    this.authservice.logout();
    this.router.navigate(['home']);
   // this.isDemandeur();
  }

 /* isDemandeur() {
    this.authservice.isDemandeur().subscribe(
      res => {this.etat = res; },
      err => console.log(err)
    );
    }*/
  }

