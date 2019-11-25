import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import { RepositoriesComponent } from './repositories/repositories.component';
import { FollowerUsersComponent } from './follower-users/follower-users.component';
import { FollowingUsersComponent } from './following-users/following-users.component';
import { RepositorySearchComponent } from './repository-search/repository-search.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AnalyzedRepositoriesComponent } from './analyzed-repositories/analyzed-repositories.component';
import { UserInfoComponent } from './user-info/user-info.component';



@NgModule({
  declarations: [DashboardComponent, RepositoriesComponent,
    FollowerUsersComponent, FollowingUsersComponent, RepositorySearchComponent, AnalyzedRepositoriesComponent, UserInfoComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
