import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { AnalyzedRepository } from './analyzed-repository.model';

@Component({
  selector: 'app-analyzed-repositories',
  templateUrl: './analyzed-repositories.component.html',
  styleUrls: ['./analyzed-repositories.component.css']
})
export class AnalyzedRepositoriesComponent implements OnInit {
  repos: AnalyzedRepository[];
  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.dashboardService.getAnalyzedRepos().subscribe((data: AnalyzedRepository[]) => {
      this.repos = data;
    });
  }

}
