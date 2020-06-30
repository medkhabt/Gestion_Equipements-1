import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignUpGestionnaireComponent } from './sign-up-gestionnaire.component';

describe('SignUpGestionnaireComponent', () => {
  let component: SignUpGestionnaireComponent;
  let fixture: ComponentFixture<SignUpGestionnaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignUpGestionnaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignUpGestionnaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
