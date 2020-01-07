import { Component, OnInit } from '@angular/core';
import { TradeItemList } from './TradeItemList';
import { FormBuilder } from '@angular/forms';
import { TradeItem } from './TradeItem';
import { PoeTradeService } from './poe-trade.service';
import { User } from '../shared/models/user';
import { Router } from '@angular/router';
import { Collection } from '../shared/models/Collection';

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
      priceHistoryUrl:'',
      collectionName:['default'],
      leagueName:['Synthesis']
    });

    this.newCollectionForm = this.formBuilder.group({
      collectionName:''
    });
  }

  itemMap: Map<string, string> = new Map<string, string>();
  tradeItems = [];
  filteredTradeItems = [];

  //Not used yet
  errorMessage = null;
  successMessage = null;

  view="current";
  currentCollection="View All";
  collections:String[]=[];
  leagues:String[]=["Legion", "Synthesis"];
  newItemForm;
  newCollectionForm;

  ngOnInit() {
    this.checkLoggedIn();
  }

  checkLoggedIn() {
    let user:User = JSON.parse(sessionStorage.getItem("user"));
    if(user==null) {
      this.router.navigate(['login']);
    } else {
      this.getItems();
      this.getCollections();
    }
  }

  addItem(tradeItem:TradeItem) {
    tradeItem.itemId = -1;
    let user:User = JSON.parse(sessionStorage.getItem("user"));
    tradeItem.userId = user.userId;
    // tradeItem.collectionName="default";
    // tradeItem.leagueName="testLeague";
    console.log(tradeItem);
    this.tradeService.addTradeItem(tradeItem).subscribe(
      tradeId => {
        tradeItem.itemId = tradeId;
        this.tradeItems.push(tradeItem);
        console.log(tradeItem);
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
        this.filteredTradeItems = tradeItems;
        console.log(tradeItems);
        this.errorMessage = null;
      }, err => {
        this.errorMessage = "Trade Items could not be found";
        this.successMessage = null;
        console.log(err);
      }
    )
  }

  addCollection(collection:Collection) {
    let user:User = JSON.parse(sessionStorage.getItem("user"));
    collection.collectionUserId = user.userId;
    this.tradeService.addCollection(collection).subscribe(
      collectionId => {
        this.collections.push(collection.collectionName);
        console.log(collection);
        this.successMessage = "Collection with id: " + collectionId + " was added successfully";
        this.errorMessage = null;
        this.view="current";
        this.newCollectionForm.reset();
      }, err => {
        this.errorMessage = "Collection failed to add";
        this.successMessage = null;
        console.log(err);
      }
    )
  }

  getCollections() {
    this.tradeService.getCollections().subscribe(
      collections => {
        this.collections = collections;
        collections.push("View All");
        this.currentCollection = "View All";
        console.log("collections: " + this.collections);
      }, err => {
        this.errorMessage = "Collections could not be fetched";
      }
    )
  }

  changeCollection(collection) {
    console.log("here");
    this.currentCollection = collection;
    this.filterTradeItems(collection);
    console.log(collection);
  }

  filterTradeItems(collection) {
    if(collection == "View All") {
      console.log("here2");
      this.filteredTradeItems = this.tradeItems;
    } else {
      this.filteredTradeItems = this.tradeItems.filter(x => x.collectionName == collection);
      console.log(this.filteredTradeItems);
    }
  }

  deleteItem(itemId) {
    this.tradeService.deleteTradeItem(itemId).subscribe(
      tradeId => {
        this.tradeItems = this.tradeItems.filter(x => x.itemId != itemId);
        this.filteredTradeItems = this.filteredTradeItems.filter(x => x.itemId != itemId);
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
