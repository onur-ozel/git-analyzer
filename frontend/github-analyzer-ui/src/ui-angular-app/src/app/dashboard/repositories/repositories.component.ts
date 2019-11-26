import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { Repo } from 'src/app/shared/models/repo.model';

@Component({
  selector: 'app-repositories',
  templateUrl: './repositories.component.html',
  styleUrls: ['./repositories.component.css']
})
export class RepositoriesComponent implements OnInit {
  repositories: Repo[];

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.dashboardService.getCurrentUserRepos().subscribe((data: Repo[]) => this.repositories = data);
  }
}
