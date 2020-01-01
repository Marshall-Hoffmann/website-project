import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PoeTradeComponent } from './poe-trade/poe-trade.component';
import { ResumeComponent } from './resume/resume.component';
import { AppComponent } from './app.component';
import { HcDeathsComponent } from './hc-deaths/hc-deaths.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [
  { path: 'poe-trade', component: PoeTradeComponent},
  { path: 'resume', component: ResumeComponent},
  { path: 'death', component: HcDeathsComponent},
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SignupComponent},
  { path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
