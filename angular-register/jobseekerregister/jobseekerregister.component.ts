import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JobSeeker } from 'src/app/Model/JobSeeker';
import { JobseekerService } from 'src/app/Shared/jobseeker.service';

@Component({
  selector: 'jobseekerregister',
  templateUrl: './jobseekerregister.component.html',
  styleUrls: ['./jobseekerregister.component.css']
})
export class JobseekerregisterComponent implements OnInit {

  myform : FormGroup;
  firstName : FormControl;
  lastName : FormControl;
  password : FormControl;
  email : FormControl;
  userName : FormControl;
  gender : FormControl;
  phoneNumber : FormControl;
  city : FormControl;
  province : FormControl;
  isFormSubmitted : boolean = false;
  message : string;
  jobSeeker : JobSeeker;
  provinces : String[];
  genders : String[];

  createForm() {
    this.myform = new FormGroup({
    firstName: this.firstName,  
    lastName: this.lastName,
    password:this.password,
    email:this.email,
    userName : this.userName,
    gender : this.gender,
    phoneNumber : this.phoneNumber,
    city: this.city,
    province : this.province
    })
  }


  createControls() {
    this.firstName = new FormControl('', Validators.required)
    this.lastName = new FormControl('', Validators.required)
    this.password = new FormControl('', Validators.required)
    this.email = new FormControl('', Validators.required)
    this.userName = new FormControl('', Validators.required)
    this.gender = new FormControl('')
    this.phoneNumber = new FormControl('')
    this.city = new FormControl('', Validators.required)
    this.province = new FormControl('', Validators.maxLength(2))

  }


  constructor( private service : JobseekerService, private router : Router) {
    this.message = '';
    this.provinces = ['AB' , 'BC', 'MB', 'NB', 'NL', 'NT', 'NS', 'NU', 'ON', 'PE', 'QC', 'SK', 'YT'];
    this.genders = ['Male', 'Female', 'Other'];
   }

  ngOnInit(): void {
    this.createControls();
    this.createForm();
  }

  onSubmit() {
    this.isFormSubmitted = true;
    if (this.firstName.value == null || this.lastName.value == null || this.password.value == null || this.email.value == null || this.userName.value == null || this.city.value == null || this.province.value == null) {
      this.message = "JobSeeker was not registered, Please enter valid details!"
    } else {
      this.jobSeeker = {firstName : this.firstName.value, lastName: this.lastName.value, password : this.password.value, email : this.email.value, userName : this.userName.value, gender : this.gender.value, phoneNumber: this.phoneNumber.value, city: this.city.value, province: this.province.value};
      this.service.addJobSeeker(this.jobSeeker).subscribe((data) => {
        console.log(data);
        this.message = 'JobSeeker was added successfully'
        this.router.navigate(['login'])  
      }, (err) => {
        console.log(err);
        this.message = 'ERROR, JobSeeker was not added'
      })
    }
    

  }

}
