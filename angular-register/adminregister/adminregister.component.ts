import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/Model/Admin';
import { AdminService } from 'src/app/Shared/admin.service';

@Component({
  selector: 'adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent implements OnInit {

  myform : FormGroup;
  firstName : FormControl;
  lastName : FormControl;
  password : FormControl;
  email : FormControl;
  isFormSubmitted : boolean = false;
  message : string;
  admin : Admin

  createForm() {
    this.myform = new FormGroup({
    firstName: this.firstName,  
    lastName: this.lastName,
    password:this.password,
    email:this.email
    })
  }

  createControls() {
    this.firstName = new FormControl('', Validators.required)
    this.lastName = new FormControl('', Validators.required)
    this.password = new FormControl('', Validators.required)
    this.email = new FormControl('', Validators.required)
  }

  constructor(private service : AdminService, private router : Router) { }

  ngOnInit(): void {
    this.createControls();
    this.createForm();
  }

  onSubmit() {
    this.isFormSubmitted = true;
    if (this.firstName.value == null || this.lastName.value == null || this.password.value == null || this.email.value == null) {
      this.message = "Admin was not registered, Please enter valid details!"
    } else {
      this.admin = {firstName : this.firstName.value, lastName: this.lastName.value, password : this.password.value, email : this.email.value};
      this.service.addAdmin(this.admin).subscribe((data) => {
        console.log(data);
        this.message = 'Admin was added successfully'
        this.router.navigate(['login'])  
      }, (err) => {
        console.log(err);
        this.message = 'ERROR, Admin was not added'
      })
    }

  }

}
