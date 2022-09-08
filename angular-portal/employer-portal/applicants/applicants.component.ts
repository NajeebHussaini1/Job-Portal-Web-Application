import { Component, Input, OnInit } from '@angular/core';
import { AppliedJobs } from 'src/app/Model/appliedjob';
import { Job } from 'src/app/Model/job';

import { Resume } from 'src/app/Model/Resume';
import { ApplicantserviceService } from 'src/app/Shared/applicantservice.service';
import { AppliedJobService } from 'src/app/Shared/appliedJobs.service';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';

import { LoggeduserService } from 'src/app/Shared/loggeduser.service';
import { ResumeService } from 'src/app/Shared/resume.service';

@Component({
  selector: 'app-applicants',
  templateUrl: './applicants.component.html',
  styleUrls: ['./applicants.component.css']
})
export class ApplicantsComponent implements OnInit {

  @Input() 
  appliedJob : Job;
  map = new Map<AppliedJobs, Resume>(); 
  applicants : AppliedJobs[] = [];
  resumes : Resume[] = [];
  headers=[' ','Email','Resume Details', 'Shortlist'];
  employerID : number;
  all : [any];
  shortlisted : boolean = false;

  constructor(private service:AppliedJobService, private jobdetailservice:JobdetailService , private appliedjobs :AppliedJobService, private loggedService : LoggeduserService, private resumeService : ResumeService, private applicantsService : ApplicantserviceService) {
    
    this.service.getAppliedJobs().subscribe(data => {
    
      for (let index = 0; index < data.length; index++) {
        if (data[index].jobID == this.applicantsService.jobId) {
          this.applicants.push(data[index])
        }
      }
      console.log(this.applicants)
      this.resumeService.getAllResumes().subscribe(data2 => {
        for (let k = 0; k < this.applicants.length; k++) {
          for (let index = 0; index < data2.length; index++) {
            if (data2[index].resumeId == this.applicants[k].resumeID) {
              this.resumes.push(data2[index])
            }
            
          }
        }
        for (let i = 0;i < this.applicants.length; i++) {
          this.map.set(this.applicants[i], this.resumes[i])
        }
        
        console.log(this.map.values())
      })

    },(error)=>{
      console.log(error.msg);
    }
    );

    this.employerID = this.loggedService.id;

  }
  
  ngOnInit() {

  }

  checkValue(event: any){
    console.log(event);
 }

 onSubmit(shortlist : any) {
   console.log({employerId : this.employerID, jobId : this.applicantsService.jobId, resumeId : shortlist})
    this.resumeService.shortListResume({employerId : this.employerID.toString(), jobId : this.applicantsService.jobId, resumeId : shortlist}).subscribe(data => {
      console.log(data)
      this.shortlisted = true;
    }, err => {
      this.shortlisted = false;
      console.log(err)
    })
 }

}

