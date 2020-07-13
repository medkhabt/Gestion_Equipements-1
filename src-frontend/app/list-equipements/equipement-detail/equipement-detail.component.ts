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
  responsables: string[] = [
    '',
    'Abdallah ELMOUNTAKI',
    'Noorelhooda AGOUZOUL',
    'Abdalkarim ELHARMLI',
    'Idriss ELMALOUMI',
    'Mohamed KRIAT'
  ];

  images: string[] = [
    '',
    'Khaireddinelmao.jpg',
    'jamalDora.jpg',
    'bensergao.jpg',
    'conservatoireMusical.jpg',
    'theatreAgadir.jpg'
  ];

  description: string [] = [
    '',
    'est le complexe ou se trouve le service des affaires culturelles',
    'est un complexe pres de l\'universite IBN ZOHR',
    'est un complexe cutlurel qui ce consentre sur les activitees musicales',
    'est un établissement public dispensant un enseignement dans les disciplines de la musique, et aussi des equpiments de la musique',
    // tslint:disable-next-line: max-line-length
    'est un cadre de végétation artistiquement aménagé permettant d\'assister en plein air1 à des spectacles vivants ou à des séances de cinéma.'
  ];
  constructor(public authService: AuthService) { }

  ngOnInit(): void {
  }


}
