import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { Repository } from 'src/app/shared/models/repository.model';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-repositories',
  templateUrl: './repositories.component.html',
  styleUrls: ['./repositories.component.css']
})
export class RepositoriesComponent implements OnInit {
  repositories: Repository[];
  totalRepostroyCount = 13;
  currentPage = 0;

  constructor(private dashboardService: DashboardService, private http: HttpClient) { }

  ngOnInit() {
    this.http.get('https://api.github.com/users/onur-ozel/repos?page=' + this.currentPage + '&per_page=5')
      .subscribe((data: any) => {
        this.repositories = data.map(repositoryItem => {
          const repository = new Repository();

          repository.name = repositoryItem.name;
          repository.fullName = repositoryItem.full_name;
          repository.isPrivate = repositoryItem.private;
          repository.url = repositoryItem.html_url;
          repository.description = repositoryItem.description;
          repository.isForked = repositoryItem.fork;
          repository.starGazersCount = repositoryItem.stargazers_count;
          repository.watchersCount = repositoryItem.watchers_count;
          repository.forksCount = repositoryItem.forks_count;
          repository.openIssuesCount = repositoryItem.open_issues_count;
          repository.language = repositoryItem.language;

          const owner = new User();
          owner.name = repositoryItem.owner.login;
          owner.id = repositoryItem.owner.id;
          owner.url = repositoryItem.owner.html_url;
          owner.avatarUrl = repositoryItem.owner.avatar_url;

          repository.owner = owner;
          return repository;
        });
      });


    // https://api.github.com/users/onur-ozel/repos?page=3&per_page=5
    // this.repositories = this.dashboardService.getRepositories();
  }

}
