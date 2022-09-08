import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Shared/admin.service';
import { LoggeduserService } from 'src/app/Shared/loggeduser.service';

@Component({
  selector: 'adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

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

  constructor(private service : AdminService, private router :Router, private loggedService : LoggeduserService) {
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
      this.service.loginAdmin( {email : this.email.value , password : this.password.value }).subscribe((data) => {
        console.log(data)
        console.log(data.id)
        this.loggedService.loginAdmin(data.id, data.firstName, data.lastName, data.email)
        this.loggedService.isUserLoggedIn.next(true)
        this.router.navigate(['portal'])
      }, (err) => {
        console.log(err)
        this.message = 'Email and password you have entered is incorrect'
      });
       
    }

  }

}
