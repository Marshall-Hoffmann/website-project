import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PoeTradeComponent } from './poe-trade/poe-trade.component';
import { ResumeComponent } from './resume/resume.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  { path: 'poe-trade', component: PoeTradeComponent},
  { path: 'resume', component: ResumeComponent},
  { path: '', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
