export class Death {

    charName:string;
    charAscendency:string;
    charLevel:number;
    timePlayed:number;
    deathLocation:string;
    deathDescription:string;

    constructor(charName:string, charAscendency:string, charLevel:number, timePlayed:number, deathLocation:string, deathDescription:string) {
        this.charName = charName;
        this.charAscendency = charAscendency;
        this.charLevel = charLevel;
        this.timePlayed = timePlayed;
        this.deathLocation = deathLocation;
        this.deathDescription = deathDescription;
    }
}