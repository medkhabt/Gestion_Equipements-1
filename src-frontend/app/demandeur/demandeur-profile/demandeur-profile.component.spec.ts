import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeurProfileComponent } from './demandeur-profile.component';

describe('DemandeurProfileComponent', () => {
  let component: DemandeurProfileComponent;
  let fixture: ComponentFixture<DemandeurProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeurProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeurProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
