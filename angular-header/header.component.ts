import { Component, Input, OnInit } from '@angular/core';

import { LoggeduserService } from '../Shared/loggeduser.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

  @Input()
  isLoggedIn : boolean;

  constructor(private service : LoggeduserService) {
    this.service.isUserLoggedIn.subscribe(value => {
      this.isLoggedIn = value;
    })
    //this.isLoggedIn = this.service.isLoggedIn;
    
   }

  ngOnInit(): void {
  }


  logout(){
    this.service.isUserLoggedIn.next(false)
    this.service.logout();
    console.log("Logged out")
  }


}
