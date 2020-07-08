import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-view',
  templateUrl: './profile-view.component.html',
  styleUrls: ['./profile-view.component.scss']
})
export class ProfileViewComponent implements OnInit {

  demandeur: any;
  recepisse: any;
  statut: any;
  profileImage: any;
  d: any;
  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
    this.d = JSON.parse(localStorage.getItem('demandeur'));
    const id = this.d.id;
    console.log(this.d);
    this.authService.getDemandeurById(id).subscribe(
      resp => {
        this.demandeur = resp;
//        this.retreivedRecepisse = 'data:image/jpeg;base64,' + this.demandeur.imageProfile;
        this.recepisse = 'data:application/pdf;base64,' + this.demandeur.recepisse;
        this.statut = 'data:application/pdf;base64,' + this.demandeur.statut;
        this.profileImage = 'data:image/jpeg;base64,' + this.demandeur.imageProfile;
      },
      err => console.log(err)
    );
  }

}
