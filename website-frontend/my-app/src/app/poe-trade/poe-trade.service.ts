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

  constructor(private httpClient:HttpClient, private loginService:LoginService) { 
    this.loginService.currentUser.subscribe(user => this.user = user);
  }

  tradeUrl = "http://localhost:8080/poe-trade/";
  user:User;


  addTradeItem(tradeItem:TradeItem) {
    return this.httpClient.post<number>(this.tradeUrl+"tradeItems", tradeItem);
  }

  deleteTradeItem(tradeId:number) {
    return this.httpClient.delete<TradeItem>(this.tradeUrl+"tradeItems/"+tradeId);
  }

  getTradeItems() {
    return this.httpClient.get<TradeItem[]>(this.tradeUrl+"tradeItems?userId=" + this.user.userId);
  }

  addCollection(collection:Collection) {
    return this.httpClient.post<number>(this.tradeUrl+"collections",collection);
  }

  getCollections() {
    return this.httpClient.get<String[]>(this.tradeUrl+"collections?userId=" + this.user.userId);
  }
}
