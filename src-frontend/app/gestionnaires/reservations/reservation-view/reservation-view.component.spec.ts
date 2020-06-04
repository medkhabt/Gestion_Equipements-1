import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationViewComponent } from './reservation-view.component';

describe('ReservationViewComponent', () => {
  let component: ReservationViewComponent;
  let fixture: ComponentFixture<ReservationViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
