import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/shared/models/user.model';
import { Repository } from 'src/app/shared/models/repository.model';

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
    this.http.get('http://localhost:8080/github/v1/statistics/top-reacted-issues')
      .subscribe((data: any) => {
        this.totalRepositoryCount = data.total_count;
        this.repositories = data.items;
      });
  }

}
