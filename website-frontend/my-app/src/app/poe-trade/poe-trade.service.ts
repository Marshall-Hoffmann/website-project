import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http'
import { TradeItem } from './TradeItem';
import { User } from '../shared/models/user';
import { LoginService } from '../login.service';

@Injectable({
  providedIn: 'root'
})
export class PoeTradeService {

  constructor(private httpClient:HttpClient, private loginService:LoginService) { }

  tradeUrl = "http://localhost:8080/poe-trade/";

  addTradeItem(tradeItem:TradeItem) {
    let user:User = JSON.parse(sessionStorage.getItem("user"));
    // let body = [tradeItem, user.email];
    return this.httpClient.post<number>(this.tradeUrl+"addTradeItem", tradeItem);
  }

  deleteTradeItem(tradeId:number) {
    return this.httpClient.delete<TradeItem>(this.tradeUrl+"deleteTradeItem/"+tradeId);
  }

  getTradeItems() {
    let user:User = JSON.parse(sessionStorage.getItem("user"));
    return this.httpClient.get<TradeItem[]>(this.tradeUrl+"getTradeItems?emailId=" + user.email);
  }
}
