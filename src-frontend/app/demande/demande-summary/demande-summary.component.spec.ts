import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeSummaryComponent } from './demande-summary.component';

describe('DemandeSummaryComponent', () => {
  let component: DemandeSummaryComponent;
  let fixture: ComponentFixture<DemandeSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
