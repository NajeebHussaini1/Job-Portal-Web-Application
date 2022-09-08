import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employer : boolean = true;
  admin : boolean = false;
  jobSeeker : boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  employerLogin() {
    this.employer = true;
    this.admin = false;
    this.jobSeeker = false;
  }

  adminLogin() {
    this.admin = true;
    this.employer = false;
    this.jobSeeker = false;
  }

  jobseekerLogin() {
    this.jobSeeker = true;
    this.admin = false;
    this.employer = false;
  }

}
