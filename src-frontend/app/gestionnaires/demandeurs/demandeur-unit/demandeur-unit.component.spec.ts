import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeurUnitComponent } from './demandeur-unit.component';

describe('DemandeurUnitComponent', () => {
  let component: DemandeurUnitComponent;
  let fixture: ComponentFixture<DemandeurUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeurUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeurUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
