import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationUnitComponent } from './reservation-unit.component';

describe('ReservationUnitComponent', () => {
  let component: ReservationUnitComponent;
  let fixture: ComponentFixture<ReservationUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
