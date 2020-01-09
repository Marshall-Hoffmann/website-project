import { Component, OnInit } from '@angular/core';
// import { SignedIn } from '../navbar/navbar.component';
import { NavbarComponent } from '../navbar/navbar.component';
import { LoginService } from '../login.service';
import { User } from '../shared/models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private loginService:LoginService) {
    this.loginService.currentUser.subscribe(user => this.user = user);
  }

  user:User;

  ngOnInit() {
  }

  

}
