import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { DemandeService } from 'src/app/services/demande.service';

@Component({
  selector: 'app-view-demande',
  templateUrl: './view-demande.component.html',
  styleUrls: ['./view-demande.component.scss']
})
export class ViewDemandeComponent implements OnInit {

  demandes: any;
  constructor(private authservice: AuthService,
              private demandeservice: DemandeService) {  }

  ngOnInit(): void {
  }

}
