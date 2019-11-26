import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { User } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-follower-users',
  templateUrl: './follower-users.component.html',
  styleUrls: ['./follower-users.component.css']
})
export class FollowerUsersComponent implements OnInit {
  followerUsers: User[];
  title: string;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.getFollowerUsers();
  }

  getFollowerUsers() {
    this.dashboardService.getCurrentUserFollowers().subscribe((data: User[]) => {
      this.title = `Total ${data.length} Followers`;
      this.followerUsers = data;
    });
  }
}
