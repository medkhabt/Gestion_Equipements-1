import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDemandeComponent } from './view-demande.component';

describe('ViewDemandeComponent', () => {
  let component: ViewDemandeComponent;
  let fixture: ComponentFixture<ViewDemandeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDemandeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDemandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
