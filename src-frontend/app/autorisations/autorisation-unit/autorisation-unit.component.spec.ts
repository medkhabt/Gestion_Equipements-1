import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorisationUnitComponent } from './autorisation-unit.component';

describe('AutorisationUnitComponent', () => {
  let component: AutorisationUnitComponent;
  let fixture: ComponentFixture<AutorisationUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorisationUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorisationUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
