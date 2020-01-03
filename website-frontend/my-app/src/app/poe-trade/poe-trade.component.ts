import { Component, OnInit } from '@angular/core';
import { TradeItemList } from './TradeItemList';
import { FormBuilder } from '@angular/forms';
import { TradeItem } from './TradeItem';
import { PoeTradeService } from './poe-trade.service';
import { User } from '../shared/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-poe-trade',
  templateUrl: './poe-trade.component.html',
  styleUrls: ['./poe-trade.component.css']
})
export class PoeTradeComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private tradeService: PoeTradeService, private router:Router) { 
    this.newItemForm = this.formBuilder.group({
      name: '',
      description:'',
      tradeUrl:'',
      priceHistoryUrl:''
    })
  }

  itemMap: Map<string, string> = new Map<string, string>();
  tradeItems = [];

  //Not used yet
  errorMessage = null;
  successMessage = null;

  view="current";
  newItemForm;

  ngOnInit() {
    this.checkLoggedIn();
  }

  checkLoggedIn() {
    let user:User = JSON.parse(sessionStorage.getItem("user"));
    if(user==null) {
      this.router.navigate(['login']);
    } else {
      this.getItems();
    }
  }

  addItem(tradeItem:TradeItem) {
    tradeItem.tradeId = -1;
    let user:User = JSON.parse(sessionStorage.getItem("user"));
    tradeItem.emailId = user.email;
    this.tradeService.addTradeItem(tradeItem).subscribe(
      tradeId => {
        tradeItem.tradeId = tradeId;
        this.tradeItems.push(tradeItem);
        this.successMessage = "Trade item with id: " + tradeId + " was added successfully";
        this.errorMessage = null;
        this.view="current";
        this.newItemForm.reset();
      }, err => {
        this.errorMessage = "Trade item failed to add";
        this.successMessage = null;
        console.log(err);
      }
    )
    
  }

  getItems() {
    this.tradeService.getTradeItems().subscribe(
      tradeItems => {
        this.tradeItems = tradeItems;
        this.errorMessage = null;
      }, err => {
        this.errorMessage = "Trade Items could not be found";
        this.successMessage = null;
        console.log(err);
      }
    )
  }

  deleteItem(itemId) {
    this.tradeService.deleteTradeItem(itemId).subscribe(
      tradeId => {
        this.tradeItems = this.tradeItems.filter(x => x.tradeId != itemId);
        this.successMessage = "Trade item with id: " + itemId + " was successfully deleted";
        this.errorMessage = null;
      }, err => {
        this.errorMessage = "Trade item could not be deleted";
        this.successMessage = null;
        console.log(err);
      }
    )
  }

}
