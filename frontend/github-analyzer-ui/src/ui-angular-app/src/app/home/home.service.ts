import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  constructor(private http: HttpClient) {

  }

  public getTopStarredRepos() {
    return this.http
      .get('github/api/v1/statistics/top-starred-repos');
  }

  public getTopReactedIssueRepos() {
    return this.http
      .get('github/api/v1/statistics/top-reacted-issues');
  }

  public getTopFollowedUsers() {
    return this.http
      .get('github/api/v1/statistics/top-followed-users');
  }
}
