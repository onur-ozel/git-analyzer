import { Component, OnInit, Input } from '@angular/core';
import { Repo } from '../../models/repo.model';
import { DashboardService } from 'src/app/dashboard/dashboard.service';

@Component({
  selector: 'app-repository',
  templateUrl: './repository.component.html',
  styleUrls: ['./repository.component.css']
})
export class RepositoryComponent implements OnInit {

  @Input() repositories: Repo[];
  readmeData: any;
  isReadmeVisible = false;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
  }

  analyzeRepo(repo: Repo) {
    this.dashboardService.analyzeRepo(repo);
  }

  showReadme(repo: Repo) {
    this.dashboardService.getReadMeFile(repo.owner.login, repo.name).subscribe(readmeData => {
      this.readmeData = readmeData;
      this.isReadmeVisible = true;
    });
  }

  onReadmeClose() {
    this.isReadmeVisible = false;
  }
}
