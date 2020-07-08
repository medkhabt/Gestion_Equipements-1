import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorisationsViewComponent } from './autorisations-view.component';

describe('AutorisationsViewComponent', () => {
  let component: AutorisationsViewComponent;
  let fixture: ComponentFixture<AutorisationsViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorisationsViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorisationsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
