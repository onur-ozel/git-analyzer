import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private authenticatedUser: User;
  isAuthenticated = new Subject<boolean>();

  constructor(private http: HttpClient) {
    this.checkIsAuthenticated();
  }

  checkIsAuthenticated() {
    return this.http.get('github/api/v1/auth/user');
  }


  getAuthenticatedUser() {
    return { ...this.authenticatedUser };
  }

  logout() {
    this.http.post('logout', {}).subscribe(() => {
      // this.isAuthenticated = false;
    });
  }
}
