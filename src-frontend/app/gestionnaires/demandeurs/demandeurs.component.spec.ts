import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeursComponent } from './demandeurs.component';

describe('DemandeursComponent', () => {
  let component: DemandeursComponent;
  let fixture: ComponentFixture<DemandeursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
