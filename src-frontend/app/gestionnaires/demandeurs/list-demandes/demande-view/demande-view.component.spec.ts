import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeViewComponent } from './demande-view.component';

describe('DemandeViewComponent', () => {
  let component: DemandeViewComponent;
  let fixture: ComponentFixture<DemandeViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
