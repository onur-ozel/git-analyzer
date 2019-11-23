import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private authenticatedUser: User;

  constructor(private http: HttpClient) {
    this.authenticatedUser = new User();

    this.authenticatedUser.id = 4484836;
    this.authenticatedUser.login = 'JosephSmith127';
    this.authenticatedUser.name = 'Joseph Smith';
    this.authenticatedUser.location = 'England';
    this.authenticatedUser.email = undefined;
    this.authenticatedUser.company = '@withjour';
    this.authenticatedUser.blog = 'http://jsmth.co';
    this.authenticatedUser.bio = 'Lead Developer @withjour';
    this.authenticatedUser.followerCount = 274;
    this.authenticatedUser.followingCount = 7;
    this.authenticatedUser.url = 'https://github.com/JosephSmith127';
    this.authenticatedUser.avatarUrl = 'https://avatars0.githubusercontent.com/u/4484836?v=4';
    this.authenticatedUser.createdAt = new Date('2013-05-21T02:37:29Z');
    this.authenticatedUser.updatedAt = new Date('2019-11-10T15:35:54Z');
  }

  getAuthenticatedUser() {
    return { ...this.authenticatedUser };
  }

  login() {
    this.http.get('http://localhost:8080/login')
      .subscribe((data: any) => {
        console.log(data);
      });
  }

  logout() {
    console.log('logout');
  }
}
