import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListEquipementsComponent } from './list-equipements.component';

describe('ListEquipementsComponent', () => {
  let component: ListEquipementsComponent;
  let fixture: ComponentFixture<ListEquipementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListEquipementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListEquipementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
