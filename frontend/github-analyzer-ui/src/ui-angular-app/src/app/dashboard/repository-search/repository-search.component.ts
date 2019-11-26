import { Component, OnInit } from '@angular/core';
// import { FormControl } from '@angular/forms';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DashboardService } from '../dashboard.service';
import { Repo } from 'src/app/shared/models/repo.model';

@Component({
  selector: 'app-repository-search',
  templateUrl: './repository-search.component.html',
  styleUrls: ['./repository-search.component.css']
})
export class RepositorySearchComponent implements OnInit {
  searchRepositoryForm = this.fb.group({
    userName: ['', [Validators.required, Validators.minLength(2)]],
    repoName: ['', [Validators.required, Validators.minLength(2)]]
  });
  totalFoundedRepositoryCount: number;
  foundedRepositories: Repo[];

  constructor(private fb: FormBuilder, private dashboardService: DashboardService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.dashboardService.searchRepositories(this.searchRepositoryForm.get('userName').value,
      this.searchRepositoryForm.get('repoName').value).subscribe((data: any) => {
        this.totalFoundedRepositoryCount = data.total_count;
        this.foundedRepositories = data.items;
      });
  }

  analyze(repo: Repo) {
    this.dashboardService.analyzeRepo(repo).subscribe(data => { console.log(data); });
  }
}
