import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipementUpdateComponent } from './equipement-update.component';

describe('EquipementUpdateComponent', () => {
  let component: EquipementUpdateComponent;
  let fixture: ComponentFixture<EquipementUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipementUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipementUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
