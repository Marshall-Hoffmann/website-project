import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HcDeathsComponent } from './hc-deaths.component';

describe('HcDeathsComponent', () => {
  let component: HcDeathsComponent;
  let fixture: ComponentFixture<HcDeathsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HcDeathsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HcDeathsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
