import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorisationChartComponent } from './autorisation-chart.component';

describe('AutorisationChartComponent', () => {
  let component: AutorisationChartComponent;
  let fixture: ComponentFixture<AutorisationChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorisationChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorisationChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
