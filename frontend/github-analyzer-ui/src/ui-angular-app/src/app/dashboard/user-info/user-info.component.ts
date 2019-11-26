import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { User } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {
  user: User;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.getUserInfo();
  }

  getUserInfo() {
    this.dashboardService.getCurrentUserInfo().subscribe((data: User) => {
      this.user = data;
    });
  }
}
