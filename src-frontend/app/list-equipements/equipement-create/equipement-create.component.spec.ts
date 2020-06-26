import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipementCreateComponent } from './equipement-create.component';

describe('EquipementCreateComponent', () => {
  let component: EquipementCreateComponent;
  let fixture: ComponentFixture<EquipementCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipementCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipementCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
