import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/shared/models/user.model';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-top-followed-users',
  templateUrl: './top-followed-users.component.html',
  styleUrls: ['./top-followed-users.component.css']
})
export class TopFollowedUsersComponent implements OnInit {
  users: User[];
  totalUserCount: number;

  constructor(private homeService: HomeService) { }

  ngOnInit() {
    this.homeService.getTopFollowedUsers().subscribe((data: any) => {
      this.totalUserCount = data.totalCount;
      this.users = data.items;
    });
  }
}
