import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profil-view',
  templateUrl: './profil-view.component.html',
  styleUrls: ['./profil-view.component.scss']
})
export class ProfilViewComponent implements OnInit {

  gestionnaire: any;

  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
    const g = JSON.parse(localStorage.getItem('gestionnaire'));
    this.authService.getGestionnaire(g.username).subscribe(
      resp => {
        this.gestionnaire = resp;
        console.log(this.gestionnaire);
      },
      err => console.log(err)
    );
  }

}
