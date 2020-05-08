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


  constructor(public auhtservice: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  onLogout() {
    this.auhtservice.logout();
    this.router.navigate(['home']);
  }


}
