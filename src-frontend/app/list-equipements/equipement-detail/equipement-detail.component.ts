import { Component, OnInit, Input } from '@angular/core';
import { Equipement } from 'src/app/models/equipement.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-equipement-detail',
  templateUrl: './equipement-detail.component.html',
  styleUrls: ['./equipement-detail.component.scss']
})
export class EquipementDetailComponent implements OnInit {
  @Input()  equipement: Equipement;
  constructor(public authService: AuthService) { }

  ngOnInit(): void {
  }

}
