import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import { UserComponent } from './user/user.component';
import { RepositoriesComponent } from './repositories/repositories.component';
import { FollowerUsersComponent } from './follower-users/follower-users.component';
import { FollowingUsersComponent } from './following-users/following-users.component';



@NgModule({
  declarations: [DashboardComponent, UserComponent, RepositoriesComponent, FollowerUsersComponent, FollowingUsersComponent],
  imports: [
    CommonModule
  ]
})
export class DashboardModule { }
