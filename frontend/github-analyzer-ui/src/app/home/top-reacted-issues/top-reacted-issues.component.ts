import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Issue } from './issue.model';
import { User } from 'src/app/shared/models/user.model';

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
        this.totalIssueCount = data.totalCount;
        this.issues = data.items;
      });

  }

}



