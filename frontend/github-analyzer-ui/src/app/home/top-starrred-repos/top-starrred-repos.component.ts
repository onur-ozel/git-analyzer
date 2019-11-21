import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Repository } from './repository.model';
import { User } from '../top-reacted-issues/user.model';

@Component({
  selector: 'app-top-starrred-repos',
  templateUrl: './top-starrred-repos.component.html',
  styleUrls: ['./top-starrred-repos.component.css']
})
export class TopStarrredReposComponent implements OnInit {
  repositories: Repository[];
  totalRepositoryCount: number;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/github/v1/statistics/top-starred-repos')
      .subscribe((data: any) => {
        this.totalRepositoryCount = data.total_count;
        this.repositories = data.items.map(repositoryItem => {
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
  }

}
