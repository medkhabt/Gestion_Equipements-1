import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private auth: AuthService,
              private router: Router) { }
private isAuth = true;
         canActivate(): boolean {
         if (this.isAuth) {
          console.log ('bye');
          this.router.navigate(['auth/signin']);
          return false;
         }
         return true;
     }

}
