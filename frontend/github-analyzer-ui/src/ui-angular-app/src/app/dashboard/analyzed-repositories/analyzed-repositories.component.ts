import { Component, OnInit, OnDestroy } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { AnalyzedRepo } from './analyzed-repo.model';
import { User } from 'src/app/shared/models/user.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-analyzed-repositories',
  templateUrl: './analyzed-repositories.component.html',
  styleUrls: ['./analyzed-repositories.component.css']
})
export class AnalyzedRepositoriesComponent implements OnInit, OnDestroy {
  repos: AnalyzedRepo[];
  newAnalyzeHappened: Subscription;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.getAnalyzedRepos();

    this.newAnalyzeHappened = this.dashboardService.newAnalyzeHappened.subscribe(x => {
      this.getAnalyzedRepos();
    });
  }

  getAnalyzedRepos() {
    this.dashboardService.getAnalyzedRepos().subscribe((data: AnalyzedRepo[]) => {
      this.repos = data;
    });
  }

  ngOnDestroy(): void {
    this.newAnalyzeHappened.unsubscribe();
  }
}
