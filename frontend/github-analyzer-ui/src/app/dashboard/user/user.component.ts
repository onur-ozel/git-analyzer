import { Component, OnInit } from '@angular/core';

import { DashboardService } from '../dashboard.service';
import { User } from 'src/app/shared/models/user.model';
import { AuthenticationService } from 'src/app/shared/services/authentication.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  authenticatedUser: User;

  constructor(private dashboardService: DashboardService, private authService: AuthenticationService, private http: HttpClient) { }

  ngOnInit() {

  }

  isAuth() {
    // const header = {
    //   headers: new HttpHeaders()
    //     .set('Authorization', `Bearer 7fe67153389304a837cfc69e9db989bc8d9c3924}`).set('Access-Control-Allow-Origin', '*')
    // };

    this.http.get('http://localhost:8080/auth-required')
      .subscribe((data: any) => {
        alert(data);
      });

  }

  authUser() {
    //   var headers =
    //   new Headers({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
    //   'Authorization': 'Bearer '+Cookie.get('access_token')});
    // var options = new RequestOptions({ headers: headers });

    // {
    //   headers: {
    //     'Accept': 'application/json',
    //     'Authorization': 'Basic ' + btoa(user.username + ':' + user.password)
    //   }
    // }
    //   const header = {
    //     headers: new HttpHeaders()
    //       // .set('Content-type', 'application/x-www-form-urlencoded; charset=utf-8')
    //       .set('Authorization', `Bearer d5f2542a494085182106b0cb670ef1b3de236dc0`)
    //     // .set('Access-Control-Allow-Origin', '*')
    //   };
    //   // let headers =
    //   // new Headers({'Content-type': ,
    //   // 'Authorization': `Bearer 2d9eca3513c90242424592b67f16c95928877ac8`});
    //   // let options = new RequestOptions({ headers: headers });

    this.http.get('http://localhost:8080/user', {
      headers: {
        'Content-type': 'application/json',
        'Authorization': `Bearer 5f9d4f0669fb0f22e9c7c8b5ff38d6091508cdb8`,

      }, responseType: 'text'
    })
      .subscribe((data: any) => {
        console.log(data);
      });

  }

  authNone() {
    // const header = {
    //   headers: new HttpHeaders()
    //     .set('Authorization', `Bearer 7fe67153389304a837cfc69e9db989bc8d9c3924}`).set('Access-Control-Allow-Origin', '*')
    // };

    this.http.get('http://localhost:8080/auth-none')
      .subscribe((data: any) => {
        alert(data);
      });

  }
}
