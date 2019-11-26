import { Component, OnInit } from '@angular/core';
import { Repo } from 'src/app/shared/models/repo.model';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-top-starrred-repos',
  templateUrl: './top-starrred-repos.component.html',
  styleUrls: ['./top-starrred-repos.component.css']
})
export class TopStarrredReposComponent implements OnInit {
  repositories: Repo[];
  totalRepositoryCount: number;

  constructor(private homeService: HomeService) { }

  ngOnInit() {

    this.homeService.getTopStarredRepos().subscribe((data: any) => {
      this.totalRepositoryCount = data.totalCount;
      this.repositories = data.items;
    });
  }
}
