import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandesChartComponent } from './demandes-chart.component';

describe('DemandesChartComponent', () => {
  let component: DemandesChartComponent;
  let fixture: ComponentFixture<DemandesChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandesChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandesChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
