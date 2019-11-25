import { Component, OnInit } from '@angular/core';
import { Repository } from 'src/app/shared/models/repository.model';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-top-starrred-repos',
  templateUrl: './top-starrred-repos.component.html',
  styleUrls: ['./top-starrred-repos.component.css']
})
export class TopStarrredReposComponent implements OnInit {
  repositories: Repository[];
  totalRepositoryCount: number;

  constructor(private homeService: HomeService) { }

  ngOnInit() {
    this.homeService.getTopStarredRepos().subscribe((data: any) => {
      this.totalRepositoryCount = data.totalCount;
      this.repositories = data.items;
    });
  }
}
