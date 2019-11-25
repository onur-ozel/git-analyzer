import { Component, OnInit } from '@angular/core';
// import { FormControl } from '@angular/forms';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DashboardService } from '../dashboard.service';
import { Repository } from 'src/app/shared/models/repository.model';

@Component({
  selector: 'app-repository-search',
  templateUrl: './repository-search.component.html',
  styleUrls: ['./repository-search.component.css']
})
export class RepositorySearchComponent implements OnInit {
  searchRepositoryForm = this.fb.group({
    userName: ['', [Validators.required, Validators.minLength(2)]],
    repositoryName: ['', [Validators.required, Validators.minLength(2)]]
  });
  totalFoundedRepositoryCount: number;
  foundedRepositories: Repository[];

  constructor(private fb: FormBuilder, private dashboardService: DashboardService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.dashboardService.searchRepositories(this.searchRepositoryForm.get('userName').value,
      this.searchRepositoryForm.get('repositoryName').value).subscribe((data: any) => {
        this.totalFoundedRepositoryCount = data.total_count;
        this.foundedRepositories = data.items;
      });
  }
}
