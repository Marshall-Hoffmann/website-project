import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './shared/models/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  loggedInUserDetails = new BehaviorSubject<User>(JSON.parse(sessionStorage.getItem("user")));
  currentUser = this.loggedInUserDetails.asObservable();

  updateUser(user:User) {
    this.loggedInUserDetails.next(user);
  }

  login(user:User): Observable<User> {
    let url = "http://localhost:8080/";
    return this.http.post<User>(url+"login/", user);
  }

}
