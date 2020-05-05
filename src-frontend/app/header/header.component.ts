import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() pageChoosen = new EventEmitter<string>(); 
  constructor() { }

  ngOnInit(): void {
  }

  onTogglePage(name: string){
    this.pageChoosen.emit(name); 
  }
}
