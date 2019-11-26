import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'app-following-users',
  templateUrl: './following-users.component.html',
  styleUrls: ['./following-users.component.css']
})
export class FollowingUsersComponent implements OnInit {
  followingUsers: User[];
  title: string;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.getFollowingUsers();
  }

  getFollowingUsers() {
    this.dashboardService.getCurrentUserFollowings().subscribe((data: User[]) => {
      this.title = `Total ${data.length} Followings`;
      this.followingUsers = data;
    });
  }


  prepTestData() {
    const user = new User();


    user.login = 'pattern-lab';
    user.id = 4733935;
    user.avatarUrl = 'https://avatars3.githubusercontent.com/u/4733935?v=4';
    user.url = 'https://github.com/pattern-lab';
    user.name = 'Pattern Lab';
    user.company = null;
    user.blog = 'http://patternlab.io';
    user.location = null;
    user.email = null;
    user.bio = null;
    user.followerCount = 0;
    user.followingCount = 0;
    user.createdAt = new Date('2013-06-19T01:49:45Z');
    user.updatedAt = new Date('2017-11-20T20:30:51Z');


    this.followingUsers = [];

    this.followingUsers.push(user);
    this.followingUsers.push(user);
    this.followingUsers.push(user);
    this.followingUsers.push(user);
    this.followingUsers.push(user);
    this.followingUsers.push(user);
    this.followingUsers.push(user);
    this.followingUsers.push(user);

    this.title = `Total ${this.followingUsers.length} Following`;
  }

}
