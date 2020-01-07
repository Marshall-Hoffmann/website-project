import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http'
import { TradeItem } from './TradeItem';
import { User } from '../shared/models/user';
import { LoginService } from '../login.service';
import { Collection } from '../shared/models/Collection';

@Injectable({
  providedIn: 'root'
})
export class PoeTradeService {

  constructor(private httpClient:HttpClient, private loginService:LoginService) { }

  tradeUrl = "http://localhost:8080/poe-trade/";
  user:User = JSON.parse(sessionStorage.getItem("user"));

  addTradeItem(tradeItem:TradeItem) {
    return this.httpClient.post<number>(this.tradeUrl+"addTradeItem", tradeItem);
  }

  deleteTradeItem(tradeId:number) {
    return this.httpClient.delete<TradeItem>(this.tradeUrl+"deleteTradeItem/"+tradeId);
  }

  getTradeItems() {
    return this.httpClient.get<TradeItem[]>(this.tradeUrl+"getTradeItems?userId=" + this.user.userId);
  }

  addCollection(collection:Collection) {
    return this.httpClient.post<number>(this.tradeUrl+"addCollection",collection);
  }

  getCollections() {
    return this.httpClient.get<String[]>(this.tradeUrl+"getCollections?userId=" + this.user.userId);
  }
}
