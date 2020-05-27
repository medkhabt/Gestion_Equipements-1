import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeUnitComponent } from './demande-unit.component';

describe('DemandeUnitComponent', () => {
  let component: DemandeUnitComponent;
  let fixture: ComponentFixture<DemandeUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
