import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private authenticatedUser: User;
  private isAuthenticated = false;

  public isAuthenticatedChanged = new BehaviorSubject<boolean>(this.isAuthenticated);
  public authenticatedUserChanged = new BehaviorSubject<User>(this.authenticatedUser);

  constructor(private http: HttpClient) {
    this.checkIsAuthenticated();
  }

  checkIsAuthenticated() {
    return this.http.get('github/api/v1/auth/user');
  }

  getAuthenticatedUser() {
    return { ...this.authenticatedUser };
  }
}
