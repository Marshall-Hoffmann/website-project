import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PoeTradeComponent } from './poe-trade/poe-trade.component';
import { ResumeComponent } from './resume/resume.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HcDeathsComponent } from './hc-deaths/hc-deaths.component';
import { HttpClientModule } from '@angular/common/http';
import { PoeTradeService } from './poe-trade/poe-trade.service';

@NgModule({
  declarations: [
    AppComponent,
    PoeTradeComponent,
    ResumeComponent,
    HcDeathsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    PoeTradeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
