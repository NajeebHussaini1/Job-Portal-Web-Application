import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { LoggeduserService } from './loggeduser.service';

@Injectable({
  providedIn: 'root'
})
export class CanactivategaurdService implements CanActivate {

  constructor(private login : LoggeduserService) { }

  canActivate() {
    if (this.login.isLoggedIn) {
      return true;
    }
    alert("Must Be Logged In to View The Job Portal")
    return false;
  }
}
