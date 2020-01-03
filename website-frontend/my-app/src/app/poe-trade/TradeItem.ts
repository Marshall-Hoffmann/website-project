export class TradeItem {
    tradeId:number;
    name:string;
    description:string;
    tradeUrl:string;
    priceHistoryUrl:string;
    emailId:string;

    constructor(tradeId:number, name:string, description:string, tradeUrl:string, priceHistoryUrl:string, emailId:string) {
        this.tradeId = tradeId;
        this.name = name;
        this.description = description;
        this.tradeUrl = tradeUrl;
        this.priceHistoryUrl = priceHistoryUrl;
        this.emailId = emailId;
    }

}