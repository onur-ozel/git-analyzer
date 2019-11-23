import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-following-users',
  templateUrl: './following-users.component.html',
  styleUrls: ['./following-users.component.css']
})
export class FollowingUsersComponent implements OnInit {
  followingUsers: User[];

  constructor() { }

  ngOnInit() {
  }

}
