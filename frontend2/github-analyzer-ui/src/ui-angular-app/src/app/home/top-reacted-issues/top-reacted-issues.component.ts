import { Component, OnInit } from '@angular/core';
import { Issue } from '../../shared/models/issue.model';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-top-reacted-issues',
  templateUrl: './top-reacted-issues.component.html',
  styleUrls: ['./top-reacted-issues.component.css']
})
export class TopReactedIssuesComponent implements OnInit {
  issues: Issue[];
  totalIssueCount: number;

  constructor(private homeService: HomeService) { }

  ngOnInit() {
    this.homeService.getTopReactedIssueRepos().subscribe((data: any) => {
      this.totalIssueCount = data.totalCount;
      this.issues = data.items;
    });
  }
}



