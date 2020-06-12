import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeFormulaireComponent } from './demande-formulaire.component';

describe('DemandeFormulaireComponent', () => {
  let component: DemandeFormulaireComponent;
  let fixture: ComponentFixture<DemandeFormulaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeFormulaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeFormulaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
