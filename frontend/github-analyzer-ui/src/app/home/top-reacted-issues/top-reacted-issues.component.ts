import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Issue } from './issue.model';
import { User } from './user.model';

@Component({
  selector: 'app-top-reacted-issues',
  templateUrl: './top-reacted-issues.component.html',
  styleUrls: ['./top-reacted-issues.component.css']
})
export class TopReactedIssuesComponent implements OnInit {
  issues: Issue[];
  totalIssueCount: number;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/github/v1/statistics/top-reacted-issues')
      .subscribe((data: any) => {
        this.totalIssueCount = data.total_count;
        this.issues = data.items.map(issiueItem => {
          const issue = new Issue();

          issue.title = issiueItem.title;
          issue.body = issiueItem.body;
          issue.commentCount = issiueItem.comments;
          issue.updatedAt = issiueItem.updated_at;
          issue.createdAt = issiueItem.created_at;
          issue.issiueNo = issiueItem.number;
          issue.isLocked = issiueItem.locked;
          issue.url = issiueItem.html_url;

          const user = new User();
          user.name = issiueItem.user.login;
          user.id = issiueItem.user.id;
          user.url = issiueItem.user.html_url;
          user.avatarUrl = issiueItem.user.avatar_url;

          issue.user = user;
          return issue;
        });
      });

  }

}



