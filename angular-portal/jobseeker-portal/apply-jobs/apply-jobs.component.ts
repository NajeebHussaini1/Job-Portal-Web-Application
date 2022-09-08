import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppliedJobs } from 'src/app/Model/appliedjob';
import { Resume } from 'src/app/Model/Resume';
import { AppliedJobService } from 'src/app/Shared/appliedJobs.service';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';
import { LoggeduserService } from 'src/app/Shared/loggeduser.service';
import { ResumeService } from 'src/app/Shared/resume.service';

@Component({
  selector: 'app-apply-jobs',
  templateUrl: './apply-jobs.component.html',
  styleUrls: ['./apply-jobs.component.css']
})
export class ApplyJobsComponent implements OnInit {


jobs:any=[];
resumes : Resume[] = [];
resumeId : string = "";
waitforjobs:any;
appliedmessage:any;
alreadyapplied:any;
errormessage:any;
totaljobs:any;
headers=['Company Name','Job Role','Skills','Job Type','Experience','JobId',''];
  constructor(private jobdetailservice:JobdetailService , private appliedjobs :AppliedJobService, private loggedService : LoggeduserService, private resumeService : ResumeService, private router : Router) {
    this.resumeService.getAllResumes().subscribe(data => {
      console.log(data);
      this.resumes = data;
      for (let index = 0; index < this.resumes.length; index++) {
        if(this.resumes[index].userName == this.loggedService.userName) {
          this.resumeId = this.resumes[index].resumeId
        }
      }
      console.log(this.resumeId)
    })
   }
  
  ngOnInit() {
  this.getjobs();
  }



  getjobs()
  {
    this.jobdetailservice.getAllJobs().subscribe(
      (response:any)=>
    {
      if(response && response.length>0)
      {
        console.log(response);
        this.jobs=response;
        this.totaljobs=response.length;
      } 
    },
    (error)=>{
      console.log(error.msg);
    }
    );
  }
  apply(jobapply:any)
  {

    let appliedJob : AppliedJobs = {jobID : Number(jobapply.jobId), candidateID: Number(this.loggedService.id), resumeID: this.resumeId, userName: this.loggedService.userName, email: this.loggedService.email }
    console.log("success");
    this.appliedjobs.createAppliedJob(appliedJob).subscribe(
      (response:any)=>{
        if(response.status && response.status==1){
          console.log(response);
         this.router.navigate(['appliedjobs'])
         this.appliedmessage=response.message;
         
         setTimeout(()=>{
          this.appliedmessage='';
          this.getjobs();
         },2000) ;
        }else{
          this.alreadyapplied=response.message; 
          setTimeout(()=>{
            this.alreadyapplied='';
            //this.getjobs();
           },1000);
        }
        
      },(err)=>{
        this.errormessage=err.message;
      }
    );
    
  }
}

/**
 * onSubmit() {
    console.log("success")
    this.isFormSubmitted = true;
    if (this.firstName.value == null || this.lastName.value == null || this.userName.value == null || this.email.value == null || this.phoneNumber.value == null ||this.addressLine1.value == null ||this.addressLine2.value == null ||  this.country.value == null||this.state.value == null || this.city.value == null||this.highestLevelOfEducation.value == null) {
      this.message = " Please enter details!"
    } else{
      this.resume={firstName:this.firstName.value , lastName:this.lastName.value , userName:this.userName.value, candidateEmail:this.email.value,phoneNumber:this.phoneNumber.value , addressLine1:this.addressLine1.value , addressLine2:this.addressLine2.value, country:this.country.value , state:this.state.value , city:this.city.value , highestLevelOfEducation:this.highestLevelOfEducation.value }
      this.service.createResume(this.resume).subscribe((data) =>{
        console.log(data);
        this.message="Information was successfully added"
        this.router.navigate(['JobSeeker View'])
      },(err)=>{
       console.log(err);
       this.message='ERROR, enter the necessary information'
      })

    }
 */











