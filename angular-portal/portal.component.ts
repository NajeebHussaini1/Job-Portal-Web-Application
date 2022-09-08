import { Component, OnInit } from '@angular/core';
import { Job } from '../Model/job';
import { LoggeduserService } from '../Shared/loggeduser.service';

@Component({
  selector: 'app-portal',
  templateUrl: './portal.component.html',
  styleUrls: ['./portal.component.css']
})
export class PortalComponent implements OnInit {

  employerView : boolean = false;
  jobSeekerView : boolean = false;
  adminView : boolean = false;

  constructor(private service : LoggeduserService) {
    this.employerView = this.service.employerLoggedIn;
    this.jobSeekerView = this.service.jobSeekerLoggedIn;
    this.adminView = this.service.adminLoggedIn;
    console.log(this.service.isLoggedIn)
   }

  ngOnInit(): void {
  }


}
