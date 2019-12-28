import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PoeTradeComponent } from './poe-trade.component';

describe('PoeTradeComponent', () => {
  let component: PoeTradeComponent;
  let fixture: ComponentFixture<PoeTradeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PoeTradeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PoeTradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
