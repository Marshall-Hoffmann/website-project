import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './shared/models/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient) { }

  private loggedInUserDetails = new BehaviorSubject<User>(JSON.parse(sessionStorage.getItem("user")));
  currentUser = this.loggedInUserDetails.asObservable();

  updateUser(user:User) {
    this.loggedInUserDetails.next(user);
  }

  signup(user:User): Observable<User> {
    let url = "http://localhost:8080/";
    return this.http.post<User>(url+"signup/", user);
  }
}
