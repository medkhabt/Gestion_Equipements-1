import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipementSumComponent } from './equipement-sum.component';

describe('EquipementSumComponent', () => {
  let component: EquipementSumComponent;
  let fixture: ComponentFixture<EquipementSumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipementSumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipementSumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
