import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../shared/services/authentication.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private authService: AuthenticationService, private http: HttpClient) { }

  ngOnInit() {
  }

  login() {
    const uri = 'https://github.com/login/oauth/authorize?client_id=e46ca26359ef71b5285c&response_type=code&state=dTdPuI';
    const uri2 = 'http://localhost:8080/login';

    this.http.get(uri)
      .subscribe((data: any) => {
        console.log(data);
      });

    // this.authService.login();
  }

}
