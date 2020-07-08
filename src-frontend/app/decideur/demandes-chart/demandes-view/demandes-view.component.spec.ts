import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandesViewComponent } from './demandes-view.component';

describe('DemandesViewComponent', () => {
  let component: DemandesViewComponent;
  let fixture: ComponentFixture<DemandesViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandesViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
