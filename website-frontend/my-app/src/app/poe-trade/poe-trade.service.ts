import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http'
import { TradeItem } from './TradeItem';

@Injectable({
  providedIn: 'root'
})
export class PoeTradeService {

  constructor(private httpClient:HttpClient) { }

  tradeUrl = "http://localhost:8080/poe-trade/";

  addTradeItem(tradeItem:TradeItem) {
    return this.httpClient.post<number>(this.tradeUrl+"addTradeItem", tradeItem);
  }

  deleteTradeItem(tradeId:number) {
    return this.httpClient.delete<TradeItem>(this.tradeUrl+"deleteTradeItem/"+tradeId);
  }

  getTradeItems() {
    return this.httpClient.get<TradeItem[]>(this.tradeUrl+"getTradeItems");
  }
}
