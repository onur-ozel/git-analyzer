import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { AnalyzedRepo } from './analyzed-repo.model';

@Component({
  selector: 'app-analyzed-repositories',
  templateUrl: './analyzed-repositories.component.html',
  styleUrls: ['./analyzed-repositories.component.css']
})
export class AnalyzedRepositoriesComponent implements OnInit {
  repos: AnalyzedRepo[];
  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.dashboardService.getAnalyzedRepos().subscribe((data: AnalyzedRepo[]) => {
      this.repos = data;
    });
  }

}
