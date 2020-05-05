import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-equipement-sum',
  templateUrl: './equipement-sum.component.html',
  styleUrls: ['./equipement-sum.component.css']
})
export class EquipementSumComponent implements OnInit {
  @Input() name: string; 
  @Output() selectEquipement = new EventEmitter<void>(); 
  constructor() { }

  ngOnInit(): void {
  }
  onSelectEquipement(){
    this.selectEquipement.emit(); 
  }

}
