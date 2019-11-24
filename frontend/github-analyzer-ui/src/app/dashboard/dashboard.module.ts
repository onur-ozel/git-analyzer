import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import { UserComponent } from './user/user.component';
import { RepositoriesComponent } from './repositories/repositories.component';
import { FollowerUsersComponent } from './follower-users/follower-users.component';
import { FollowingUsersComponent } from './following-users/following-users.component';
import { RepositorySearchComponent } from './repository-search/repository-search.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AnalyzedRepositoriesComponent } from './analyzed-repositories/analyzed-repositories.component';



@NgModule({
  declarations: [DashboardComponent, UserComponent, RepositoriesComponent,
    FollowerUsersComponent, FollowingUsersComponent, RepositorySearchComponent, AnalyzedRepositoriesComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
