
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


import { LoggeduserService } from '../../../Shared/loggeduser.service';
import { ResumeService } from '../../../Shared/resume.service';
import { Resume } from 'src/app/Model/Resume';

@Component({
  selector: 'resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.css']
})
export class ResumeComponent implements OnInit {
  myform : FormGroup;
  expform : FormArray;
  firstName : FormControl;
  lastName : FormControl;
  userName : FormControl;
  primaryNumber : FormControl;
  email : FormControl;
  addressLine1: FormControl;
  addressLine2:FormControl;
  country : FormControl;
  state : FormControl;
  city : FormControl;
  highestLevelOfEducation : FormControl;
  resume:Resume;

  resumeAddCounter:string[];
  
  resumeId : number;

  resumes : Resume[];

  createForm() {
    this.myform = new FormGroup({
    firstName: this.firstName,  
    lastName: this.lastName,
    userName : this.userName,
    primaryNumber:this.primaryNumber,
    email:this.email,
    addressLine1:this.addressLine1,
    addressLine2:this.addressLine2,
    country:this.country,
    state:this.state,
    city: this.city,
    highestLevelOfEducation:this.highestLevelOfEducation,
    expform: this.fb.array([this.createExperienceFormDetails()])
    })
  }


  createExperienceFormDetails(): FormGroup{
    return this.fb.group({
      startDate:new FormControl('', Validators.required),
      endDate:new FormControl('', Validators.required),
      technologies:new FormControl('', Validators.required),
      firmName:new FormControl('', Validators.required),
      designation:new FormControl('', Validators.required),
      yearsOfExperience:new FormControl('', Validators.required),
      description:new FormControl('', Validators.required),
      
    });
  }


  addExperienceDetails():void{
    console.log("addexp")
    this.expform = this.myform.get('expform') as FormArray;
    console.log(this.expform);
    this.expform.push(this.createExperienceFormDetails());
    
  }
  
  createControls() {
    this.firstName = new FormControl('', Validators.required)
    this.lastName = new FormControl('', Validators.required)
    this.userName = new FormControl('', Validators.required)
    this.primaryNumber = new FormControl('')
    this.email = new FormControl('', Validators.required)
    this.addressLine1 = new FormControl('', Validators.required)
    this.addressLine2 = new FormControl('', Validators.required)
    this.country = new FormControl('', Validators.required)
    this.state = new FormControl('', Validators.required)
    this.city = new FormControl('', Validators.required)
    this.highestLevelOfEducation = new FormControl('' , Validators.required)

  }
  constructor( private fb:FormBuilder, private service : ResumeService, private router : Router, private loggedService : LoggeduserService) {
    this.message = '';
   // this.resumeAddCounter.push("1");
    service.getAllResumes().subscribe(data => {
      this.resumes = data;
    })
   }

  
  isFormSubmitted : boolean = false;
    message : string;
  

  ngOnInit(): void {
    this.createControls();
    this.createForm();
  }
  onSubmit(){
  console.log(this)
  console.log(this.myform.controls.expform)
    this.isFormSubmitted = true;
    if (this.firstName.value == null || this.lastName.value == null || this.userName.value == null || this.email.value == null || this.primaryNumber.value == null ||this.addressLine1.value == null ||this.addressLine2.value == null ||  this.country.value == null||this.state.value == null || this.city.value == null||this.highestLevelOfEducation.value == null) {
      this.message = " Please enter details!"
    } else{
      this.resumeId = this.resumes.length + 1;
      this.resume={ resumeId: this.resumeId.toString()  , firstName:this.loggedService.firstName , lastName:this.loggedService.lastName , userName:this.loggedService.userName, email:this.loggedService.email,primaryNumber:this.loggedService.phoneNumber , addressLine1:this.addressLine1.value , addressLine2:this.addressLine2.value, country:this.country.value , state:this.loggedService.province , city:this.loggedService.city , highestLevelOfEducation:this.highestLevelOfEducation.value, experiences:this.myform.controls.expform.value}
      console.log(this.resume)
      this.service.createResume(this.resume).subscribe((data) =>{
        console.log(data);
        this.message="Information was successfully added"
        this.router.navigate(['portal'])
      },(err)=>{
       console.log(err);
       this.message='ERROR, enter the necessary information'
      })

    }
  }
 }

    

 
  








































