import { Component, OnInit } from '@angular/core';
import { AdminService } from '../Shared/admin.service';
import { EmployerService } from '../Shared/employer.service';
import { JobseekerService } from '../Shared/jobseeker.service';
import { LoggeduserService } from '../Shared/loggeduser.service';
import { FormGroup,FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  myform:FormGroup;
  formEmail:FormControl;
  firstName : string;
  lastName : string;
  companyName : string;
  email : string;
  userName : string;
  city : string;
  province : string;
  phoneNumber : string;
  gender : string;
  category : string;
  about  : string;
  employerLogin : boolean;
  jobSeekerLogin : boolean;
  adminLogin : boolean;
  edit : boolean = false;
  public id : number;
  employerRole : string = "EMPLOYER";
  adminRole : string = "ADMIN"
  jobSeekerRole : string = "JOBSEEKER"
  newEmail : string;

  createForm() {
    this.myform = new FormGroup({
    email:this.formEmail
    })
  }

  createControls() {
    this.formEmail = new FormControl(this.email, Validators.required)
  }


  constructor(private service : LoggeduserService, private employerService : EmployerService, private jobSeekerService : JobseekerService, private adminService : AdminService ) {
    this.employerLogin = this.service.employerLoggedIn;
    this.adminLogin = this.service.adminLoggedIn;
    this.jobSeekerLogin = this.service.jobSeekerLoggedIn;
    this.firstName = this.service.firstName;
    this.lastName = this.service.lastName;
    this.companyName = this.service.companyName;
    this.email = this.service.email;
    this.userName = this.service.userName;
    this.city = this.service.city;
    this.province = this.service.province;
    this.phoneNumber = this.service.phoneNumber;
    this.gender = this.service.gender;
    this.category = this.service.category;
    this.about = this.service.about;
    this.id = this.service.id;
    this.newEmail = this.service.email;
  }

  ngOnInit(): void {
    this.createControls()
    this.createForm()
  }

  changeEmail() {
    this.edit = !this.edit;
  }

  updateEmail() {
    if (this.newEmail != null || this.newEmail != "") {
      if(this.employerLogin) {
        this.employerService.updateEmployer({id : this.id, email : this.formEmail.value}).subscribe(data => {
          console.log(data);
          this.email = this.formEmail.value
          this.service.email = this.formEmail.value
          this.edit = false;
        }, err => {
          console.log(err);
        })
      }
      if (this.adminLogin) {
        this.adminService.updateAdmin({id : this.id, email : this.formEmail.value}).subscribe(data => {
          console.log(data);
          this.email = this.formEmail.value
          this.service.email = this.formEmail.value
          this.edit = false;
        }, err => {
          console.log(err);
        })
      }
      if (this.jobSeekerLogin) {
        this.jobSeekerService.updateJobSeekers({id : this.id, email : this.formEmail.value}).subscribe(data => {
          console.log(data);
          this.email = this.formEmail.value
          this.service.email = this.formEmail.value
          this.edit = false;
        }, err => {
          console.log(err);
        })
      }
    } 
    
  }

}
