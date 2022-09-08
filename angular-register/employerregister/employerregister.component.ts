import { Component, OnInit } from '@angular/core';
import { EmployerService } from 'src/app/Shared/employer.service';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { Employer } from 'src/app/Model/Employer';
import { Router } from '@angular/router';

@Component({
  selector: 'employerregister',
  templateUrl: './employerregister.component.html',
  styleUrls: ['./employerregister.component.css']
})
export class EmployerregisterComponent implements OnInit {

  myform : FormGroup;
  companyName : FormControl;
  password : FormControl;
  email : FormControl;
  category : FormControl;
  about : FormControl;
  isFormSubmitted : boolean = false;
  message : string;
  employer : Employer
  categories : String[];
  createForm() {
    this.myform = new FormGroup({
    companyName: this.companyName,  
    password:this.password,
    email:this.email,
    category : this.category,
    about : this.about
    })
  }


  createControls() {
    this.companyName = new FormControl('', Validators.required)
    this.password = new FormControl('', Validators.required)
    this.email = new FormControl('', Validators.required)
    this.category = new FormControl('', Validators.required)
    this.about = new FormControl('', Validators.maxLength(250))
  }


  constructor( private service : EmployerService, private router : Router) {
    this.message = '';
    this.categories = ['Accounting', 'Finance', 'Sales', 'Marketing', 'Information Technology', 'Engineering']
   }

  ngOnInit(): void {
    this.createControls();
    this.createForm();
  }

  onSubmit() {
    this.isFormSubmitted = true;
    if (this.companyName.value == null || this.password.value == null || this.email.value == null || this.category.value == null) {
      this.message = "Employer was not registered, Please enter valid details!"
    } else {
      this.employer = {companyName : this.companyName.value, password : this.password.value, email : this.email.value, category : this.category.value, about : this.about.value};
      this.service.addEmployer(this.employer).subscribe((data) => {
        console.log(data);
        this.message = 'Employer was added successfully'
        this.router.navigate(['login'])  
      }, (err) => {
        console.log(err);
        this.message = 'ERROR, Employer was not added'
      })
    }
    

  }

}
