import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../shared/services/authentication.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private authService: AuthenticationService) { }

  isAuthenticated = false;

  ngOnInit() {
    this.authService.checkIsAuthenticated().subscribe(data => {
      console.log(data);
      this.isAuthenticated = true;
      this.router.navigate(['dashboard']);
    }, err => {
      this.isAuthenticated = false;
    });
  }



  login() {
    this.router.navigate(['dashboard']);
  }
}
