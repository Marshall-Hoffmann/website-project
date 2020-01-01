import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../shared/models/user';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginService:LoginService) {
    this.loginService.currentUser.subscribe(user => this.loggedInUser = user);

    this.loggedInUser = JSON.parse(sessionStorage.getItem("user"));
    console.log(this.loggedInUser);
  }

  ngOnInit() {
  }

  

  loggedInUser: User;
  signedIn:boolean = false;
  
  getSignedIn() {
    return this.signedIn;
  }

  signout() {
    sessionStorage.clear();
    this.loggedInUser = JSON.parse(sessionStorage.getItem("user"));
  }
}
