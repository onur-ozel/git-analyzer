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

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.dashboardService.getCurrentUserFollowers().subscribe((data: User[]) => this.followerUsers = data);
  }

}
