import { TestBed } from '@angular/core/testing';

import { PoeTradeService } from './poe-trade.service';

describe('PoeTradeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PoeTradeService = TestBed.get(PoeTradeService);
    expect(service).toBeTruthy();
  });
});
