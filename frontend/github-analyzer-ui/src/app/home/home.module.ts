import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { TopStarrredReposComponent } from './top-starrred-repos/top-starrred-repos.component';
import { TopReactedIssuesComponent } from './top-reacted-issues/top-reacted-issues.component';
import { TopFollowedUsersComponent } from './top-followed-users/top-followed-users.component';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [HomeComponent, TopStarrredReposComponent, TopReactedIssuesComponent, TopFollowedUsersComponent],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  exports: [
    HomeComponent
  ]
})
export class HomeModule { }
