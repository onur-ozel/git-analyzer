import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { Subscription, Subject, Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(public authService: AuthenticationService, public router: Router) {
  }
  canActivate(): Observable<boolean> {
    return this.authService.checkIsAuthenticated().pipe(
      map(() => {
        return true;
      }),
      catchError((err: any) => {
        this.router.navigate(['home']);
        return new Observable<false>();
      })
    );
  }
}
