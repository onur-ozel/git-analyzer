import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../top-reacted-issues/user.model';

@Component({
  selector: 'app-top-followed-users',
  templateUrl: './top-followed-users.component.html',
  styleUrls: ['./top-followed-users.component.css']
})
export class TopFollowedUsersComponent implements OnInit {

  users: User[];
  totalUserCount: number;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/github/v1/statistics/top-followed-users')
      .subscribe((data: any) => {
        this.totalUserCount = data.total_count;
        this.users = data.items.map(userItem => {
          const user = new User();
          user.name = userItem.login;
          user.id = userItem.id;
          user.url = userItem.html_url;
          user.avatarUrl = userItem.avatar_url;

          return user;
        });
      });
  }
}
