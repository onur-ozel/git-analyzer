import { Injectable } from '@angular/core';
import { Repo } from '../shared/models/repo.model';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  public newAnalyzeHappened = new Subject<Repo>();

  constructor(private http: HttpClient) {

  }

  public getCurrentUserInfo() {
    return this.http
      .get('github/api/v1/github/user');
  }

  // get(url: string, options: {
  //   headers?: HttpHeaders | {
  //     [header: string]: string | string[];
  //   };
  //   observe?: 'body';
  //   params?: HttpParams | {
  //     [param: string]: string | string[];
  //   };


  public getReadMeFile(ownerName: string, repoName: string) {
    const headers = new HttpHeaders()
      .set('Content-Type', 'text/plain; charset=utf-8');

    const params = new HttpParams()
      .set('userName', ownerName)
      .set('repoName', repoName);

    return this.http
      .get('github/api/v1/github/readme/', { params: params, headers: headers, responseType: 'text' });

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
      .get(`github/api/v1/analyze/${repo.owner.login}/${repo.name}`).subscribe((newAnalyzeRepo: Repo) => {
        this.newAnalyzeHappened.next(newAnalyzeRepo);
        alert('New Analyze Added');
      });
  }


}
