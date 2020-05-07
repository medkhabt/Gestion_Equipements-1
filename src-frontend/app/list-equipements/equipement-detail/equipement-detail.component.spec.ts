import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipementDetailComponent } from './equipement-detail.component';

describe('EquipementDetailComponent', () => {
  let component: EquipementDetailComponent;
  let fixture: ComponentFixture<EquipementDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipementDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipementDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
