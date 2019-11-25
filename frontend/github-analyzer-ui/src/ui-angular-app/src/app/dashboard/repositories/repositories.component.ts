import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { Repository } from 'src/app/shared/models/repository.model';

@Component({
  selector: 'app-repositories',
  templateUrl: './repositories.component.html',
  styleUrls: ['./repositories.component.css']
})
export class RepositoriesComponent implements OnInit {
  repositories: Repository[];

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.dashboardService.getCurrentUserRepos().subscribe((data: Repository[]) => this.repositories = data);
  }
}
