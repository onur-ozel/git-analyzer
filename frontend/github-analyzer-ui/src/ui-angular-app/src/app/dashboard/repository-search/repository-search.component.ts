import { Component, OnInit } from '@angular/core';
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

  get searchRepositoryFormControls(): any { return this.searchRepositoryForm.controls; }

  foundedRepositories: Repo[];
  isSearcResultVisible = false;

  constructor(private fb: FormBuilder, private dashboardService: DashboardService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.dashboardService.searchRepositories(this.searchRepositoryForm.get('userName').value,
      this.searchRepositoryForm.get('repoName').value).subscribe((data: any) => {
        this.foundedRepositories = data.items;
        this.isSearcResultVisible = true;
      });
  }
}
