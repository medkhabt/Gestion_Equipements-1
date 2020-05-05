import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListEquipementComponent } from './list-equipement.component';

describe('ListEquipementComponent', () => {
  let component: ListEquipementComponent;
  let fixture: ComponentFixture<ListEquipementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListEquipementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListEquipementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
