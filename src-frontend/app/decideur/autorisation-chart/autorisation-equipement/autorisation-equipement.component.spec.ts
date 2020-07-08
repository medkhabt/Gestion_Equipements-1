import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorisationEquipementComponent } from './autorisation-equipement.component';

describe('AutorisationEquipementComponent', () => {
  let component: AutorisationEquipementComponent;
  let fixture: ComponentFixture<AutorisationEquipementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorisationEquipementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorisationEquipementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
