import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { Repo } from 'src/app/shared/models/repo.model';
import { User } from 'src/app/shared/models/user.model';
import { ReadmeComponent } from 'src/app/shared/components/readme/readme.component';

@Component({
  selector: 'app-repositories',
  templateUrl: './repositories.component.html',
  styleUrls: ['./repositories.component.css']
})
export class RepositoriesComponent implements OnInit {
  repositories: Repo[];

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.getRepos();
  }

  getRepos() {
    this.dashboardService.getCurrentUserRepos().subscribe((data: Repo[]) => {
      this.repositories = data;
    });
  }
}
