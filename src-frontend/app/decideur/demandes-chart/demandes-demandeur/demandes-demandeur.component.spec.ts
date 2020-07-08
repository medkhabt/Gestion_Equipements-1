import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandesDemandeurComponent } from './demandes-demandeur.component';

describe('DemandesDemandeurComponent', () => {
  let component: DemandesDemandeurComponent;
  let fixture: ComponentFixture<DemandesDemandeurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandesDemandeurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandesDemandeurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
