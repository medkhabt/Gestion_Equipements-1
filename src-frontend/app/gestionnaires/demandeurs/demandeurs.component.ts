import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-demandeurs',
  templateUrl: './demandeurs.component.html',
  styleUrls: ['./demandeurs.component.scss']
})
export class DemandeursComponent implements OnInit {
  demandeurs: any;
  searchSubject: any;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.getDemandeurs().subscribe(
      resp => {
        this.demandeurs = resp;
        console.log(resp);
      }, err => console.log(err)
    );
  //  this.demandeurs = JSON.parse(localStorage.getItem('demandeurs'));
  }

}
