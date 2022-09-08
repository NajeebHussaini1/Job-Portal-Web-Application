import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JobseekerService } from 'src/app/Shared/jobseeker.service';
import { LoggeduserService } from 'src/app/Shared/loggeduser.service';

@Component({
  selector: 'jobseekerlogin',
  templateUrl: './jobseekerlogin.component.html',
  styleUrls: ['./jobseekerlogin.component.css']
})
export class JobseekerloginComponent implements OnInit {

  myform:FormGroup

  email:FormControl
  password:FormControl
  isFormSubmitted : boolean = false;
  message : string


  createForm() {
    this.myform = new FormGroup({
    email:this.email,
    password:this.password
    })
  }

  createControls() {
    this.email = new FormControl('', Validators.required)
    this.password = new FormControl('', Validators.required)
  }

  constructor(private service : JobseekerService, private router :Router, private loggedService : LoggeduserService) {
    this.message = '';
   }

  ngOnInit(): void {
    this.createControls()
    this.createForm()
  }

  loginUser() {
    this.isFormSubmitted = true;
    if (this.email.value == null || this.password.value == null) {
      this.message = 'Email and password cannot be empty'
    } else {
      this.service.loginJobSeeker( {email : this.email.value , password : this.password.value } ).subscribe((data) => {
        console.log(data)
        console.log(data.id)
        this.loggedService.loginJobSeeker(data.id, data.userName, data.email, data.firstName, data.lastName, data.phoneNumber, data.city, data.province, data.gender)
        this.loggedService.isUserLoggedIn.next(true)
        this.router.navigate(['portal'])
      }, (err) => {
        console.log(err)
        this.message = 'Email and password you have entered is incorrect'
      });;
    }

  }


}
