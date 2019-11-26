import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Repo } from 'src/app/shared/models/repo.model';

@Component({
  selector: 'app-repository-search-result',
  templateUrl: './repository-search-result.component.html',
  styleUrls: ['./repository-search-result.component.css']
})
export class RepositorySearchResultComponent implements OnInit {

  @Input() repositories: Repo[];
  @Input() isVisible: false;
  @Output() close: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  closeModal() {
    this.isVisible = false;
    this.repositories = undefined;
    this.close.emit();
  }

}
