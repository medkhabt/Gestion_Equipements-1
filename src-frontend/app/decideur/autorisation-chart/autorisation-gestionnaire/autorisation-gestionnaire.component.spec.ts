import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorisationGestionnaireComponent } from './autorisation-gestionnaire.component';

describe('AutorisationGestionnaireComponent', () => {
  let component: AutorisationGestionnaireComponent;
  let fixture: ComponentFixture<AutorisationGestionnaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorisationGestionnaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorisationGestionnaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
