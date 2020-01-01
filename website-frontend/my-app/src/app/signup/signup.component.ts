import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User } from '../shared/models/user';
import { SignupService } from '../signup.service';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private signupService: SignupService, private router: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  user:User;
  errorMessage:string;

  signupForm = this.formBuilder.group({
    email: [''],
    name: [''],
    password: ['']
  });

  signup() {
    this.user = this.signupForm.value as User;
    this.signupService.signup(this.user).subscribe(
      (response) => {
        this.user = response;
        sessionStorage.setItem("user", JSON.stringify(this.user));
        this.loginService.updateUser(response);
        this.router.navigate(['/home']);
      }, error => {
        this.errorMessage = "Email used in another account";
      }
    )
  }

}
