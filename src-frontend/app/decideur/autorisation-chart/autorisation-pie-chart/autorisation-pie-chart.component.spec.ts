import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorisationPieChartComponent } from './autorisation-pie-chart.component';

describe('AutorisationPieChartComponent', () => {
  let component: AutorisationPieChartComponent;
  let fixture: ComponentFixture<AutorisationPieChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorisationPieChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorisationPieChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
