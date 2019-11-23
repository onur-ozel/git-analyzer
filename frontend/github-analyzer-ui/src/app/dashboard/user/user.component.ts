import { Component, OnInit } from '@angular/core';

import { DashboardService } from '../dashboard.service';
import { User } from 'src/app/shared/models/user.model';
import { AuthenticationService } from 'src/app/shared/services/authentication.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  authenticatedUser: User;

  constructor(private dashboardService: DashboardService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.authenticatedUser = this.authService.getAuthenticatedUser();
  }

}
