import { Injectable } from '@angular/core';
import { Repo } from '../shared/models/repo.model';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  constructor(private http: HttpClient) {

  }

  public getCurrentUserRepos() {
    return this.http
      .get('github/api/v1/github/repos');
  }

  public getCurrentUserFollowers() {
    return this.http
      .get('github/api/v1/github/followers');
  }

  public getCurrentUserFollowings() {
    return this.http
      .get('github/api/v1/github/followings');
  }

  public searchRepositories(userName: string, repoName: string) {
    const params = new HttpParams()
      .set('userName', userName)
      .set('repoName', repoName);

    return this.http
      .get('github/api/v1/github/search-repo/', { params });
  }

  public getAnalyzedRepos() {
    return this.http
      .get('github/api/v1/analyze');
  }

  public analyzeRepo(repo: Repo) {
    return this.http
      .get(`github/api/v1/analyze/${repo.owner.login}/${repo.name}`);
  }
}
