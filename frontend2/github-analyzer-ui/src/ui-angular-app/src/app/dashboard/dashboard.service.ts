import { Injectable } from '@angular/core';
import { Repository } from '../shared/models/repository.model';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  constructor(private http: HttpClient) {

  }

  public getCurrentUserRepos() {
    return this.http
      .get('api/v1/github/repos');
  }

  public getCurrentUserFollowers() {
    return this.http
      .get('api/v1/github/followers');
  }

  public getCurrentUserFollowings() {
    return this.http
      .get('api/v1/github/followings');
  }

  public searchRepositories(userName: string, repositoryName: string) {
    const params = new HttpParams()
      .set('userName', userName)
      .set('repositoryName', repositoryName);

    return this.http
      .get('api/v1/github/search-repo/', { params });
  }

  public getAnalyzedRepos() {
    return this.http
      .get('api/v1/analyze');
  }
}
