import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from '../shared/models/user';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginService:LoginService, private router:Router) {
    this.loginService.currentUser.subscribe(user => this.loggedInUser = user);

    this.loggedInUser = JSON.parse(sessionStorage.getItem("user"));
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
    this.router.navigate(['/home']);
  }
}
