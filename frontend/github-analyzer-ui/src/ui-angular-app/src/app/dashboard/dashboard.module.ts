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
import { SharedModule } from '../shared/shared.module';
import { RepositorySearchResultComponent } from './repository-search/repository-search-result/repository-search-result.component';

@NgModule({
  declarations: [DashboardComponent, RepositoriesComponent,
    FollowerUsersComponent, FollowingUsersComponent,
    RepositorySearchComponent, AnalyzedRepositoriesComponent,
    UserInfoComponent, RepositorySearchResultComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class DashboardModule { }
