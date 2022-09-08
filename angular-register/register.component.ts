import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  employer : boolean = true;
  admin : boolean = false;
  jobSeeker : boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  employerRegister() {
    this.employer = true;
    this.admin = false;
    this.jobSeeker = false;
  }

  adminRegister() {
    this.admin = true;
    this.employer = false;
    this.jobSeeker = false;
  }

  jobseekerRegister() {
    this.jobSeeker = true;
    this.admin = false;
    this.employer = false;
  }

}
