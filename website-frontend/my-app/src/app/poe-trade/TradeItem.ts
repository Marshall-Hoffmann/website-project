export class TradeItem {
    itemId:number;
    name:string;
    description:string;
    tradeUrl:string;
    priceHistoryUrl:string;
    userId:number;
    collectionName:String;
    leagueName:String;

    constructor(itemId:number, name:string, description:string, tradeUrl:string, priceHistoryUrl:string, userId:number, collectionName:String, leagueName:String) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.tradeUrl = tradeUrl;
        this.priceHistoryUrl = priceHistoryUrl;
        this.userId = userId;
        this.collectionName = collectionName;
        this.leagueName = leagueName;
    }

}