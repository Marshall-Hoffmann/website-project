import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { LoginService } from '../login.service';
import { User } from '../shared/models/user';
import { Router } from '@angular/router';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router: Router,
     private navbarComponent: NavbarComponent) { }

  ngOnInit() {
    this.user = new User();
  }

  user:User;
  errorMessage:String;
  successMessage:String;


  loginForm = this.formBuilder.group({
    email: [''],
    password: ['']
  });

  login() {
    this.user = this.loginForm.value as User;
    this.loginService.login(this.user).subscribe(
      (response) => {
        this.user = response;
        sessionStorage.setItem("user", JSON.stringify(this.user));
        this.loginService.updateUser(response);
        this.router.navigate(['/home']);

      }, error => {
        this.errorMessage = "Invalid credentials!";
      }
    )
  }

}
