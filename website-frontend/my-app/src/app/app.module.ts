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
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    PoeTradeComponent,
    ResumeComponent,
    HcDeathsComponent,
    HomeComponent,
    NavbarComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    PoeTradeService,
    NavbarComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
