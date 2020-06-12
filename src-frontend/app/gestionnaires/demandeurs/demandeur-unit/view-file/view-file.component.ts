import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-file',
  templateUrl: './view-file.component.html',
  styleUrls: ['./view-file.component.scss']
})
export class ViewFileComponent implements OnInit {

  id: number;
  demandeur: any;
  recepisse: any;
  constructor(private authService: AuthService,
              private router: ActivatedRoute) { }

  ngOnInit(): void {
  /*  this.id = this.router.snapshot.params.id;
    this.authService.getDemandeurById(this.id).subscribe(
      resp => {
        this.demandeur = resp;
        console.log(resp);
        this.recepisse = 'data:application/pdf;base64,' + this.demandeur.recepisse;
        console.log(this.recepisse);
      }, err => console.log(err)
    );*/
    this.recepisse = localStorage.getItem('recepisse');
  }

}
