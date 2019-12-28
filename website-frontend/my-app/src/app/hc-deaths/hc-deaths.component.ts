import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DeathList } from './DeathList';
import { Death } from './Death';

@Component({
  selector: 'app-hc-deaths',
  templateUrl: './hc-deaths.component.html',
  styleUrls: ['./hc-deaths.component.css']
})
export class HcDeathsComponent implements OnInit {

  constructor(private formBuilder: FormBuilder) {
    this.newDeathForm = this.formBuilder.group({
      charName: '',
      charAscendency: '',
      charLevel: 0,
      timePlayed: 0,
      deathLocation: '',
      deathDescription: ''
    })
  }

  newDeathForm;
  deathList;
  view="current";

  ngOnInit() {
    this.deathList = DeathList;
  }

  newDeathSubmit(formData) {
    let tempDeath = new Death(formData.charName, formData.charAscendency, formData.charLevel, 
                      formData.timePlayed, formData.deathLocation, formData.deathDescription);

    
    this.deathList.push(tempDeath);

    console.warn('Your death was added to the death list');
  }

}
