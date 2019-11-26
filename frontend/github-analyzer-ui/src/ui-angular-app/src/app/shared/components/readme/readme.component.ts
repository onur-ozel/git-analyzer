import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { DashboardService } from 'src/app/dashboard/dashboard.service';

@Component({
  selector: 'app-readme',
  templateUrl: './readme.component.html',
  styleUrls: ['./readme.component.css']
})
export class ReadmeComponent implements OnInit {
  @Input() isVisible: false;
  @Input() readmeData: any;
  @Output() close: EventEmitter<any> = new EventEmitter();

  constructor() { }

  closeModal() {
    this.isVisible = false;
    this.readmeData = undefined;
    this.close.emit();
  }

  ngOnInit() {
  }

}
