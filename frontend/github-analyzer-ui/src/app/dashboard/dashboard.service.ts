import { Injectable } from '@angular/core';
import { User } from '../shared/models/user.model';
import { Repository } from '../shared/models/repository.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  constructor(private http: HttpClient) {

  }

  getRepositories() {
    const repos = [];

    const repo1 = new Repository();
    repo1.id = 182148023;
    repo1.name = 'cassandra';
    repo1.fullName = 'onur-ozel/cassandra';
    repo1.isPrivate = false;
    repo1.url = 'https://github.com/onur-ozel/cassandra';
    repo1.description = 'Docker Official Image packaging for Cassandra';
    repo1.isForked = true;
    repo1.starGazersCount = 829;
    repo1.watchersCount = 11;
    repo1.forksCount = 5;
    repo1.openIssuesCount = 13;
    repo1.language = 'Dockerfile';

    repos.push(repo1);

    const repo2 = new Repository();
    repo2.id = 182148023;
    repo2.name = 'cassandra';
    repo2.fullName = 'onur-ozel/cassandra';
    repo2.isPrivate = false;
    repo2.url = 'https://github.com/onur-ozel/cassandra';
    repo2.description = 'Docker Official Image packaging for Cassandra';
    repo2.isForked = true;
    repo2.starGazersCount = 829;
    repo2.watchersCount = 11;
    repo2.forksCount = 5;
    repo2.openIssuesCount = 13;
    repo2.language = 'Dockerfile';

    repos.push(repo2);

    return repos;
  }

  public searchRepositories(userName: string, repositoryName: string) {
    return this.http
      .get('https://api.github.com/search/repositories?q=' + repositoryName + ' in:name+user:' + userName + '&sort=stars&order=desc');

  }
}
