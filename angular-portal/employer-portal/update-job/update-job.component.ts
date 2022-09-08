import { EventEmitter, Output } from '@angular/core';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Job } from 'src/app/Model/job';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';
import { LoggeduserService } from 'src/app/Shared/loggeduser.service';

@Component({
  selector: 'app-update-job',
  templateUrl: './update-job.component.html',
  styleUrls: ['./update-job.component.css']
})
export class UpdateJobComponent implements OnInit {

  @Input() updatedJob : Job;
  @Output() canceled = new EventEmitter<boolean>();

  myform : FormGroup;
  jobTitle : FormControl;
  jobType : FormControl;
  jobCategory : FormControl;
  jobDiscription : FormControl;
  requiredExperience : FormControl;
  requiredSkills : FormControl;
  isFormSubmitted : boolean = false;
  message : string;
  job : Job;
  types : string[];
  categories : string[]; 
  jobs : Job[];  

  createForm() {
    this.myform = new FormGroup({
    jobTitle: this.jobTitle,  
    jobType: this.jobType,
    jobCategory:this.jobCategory,
    jobDiscription:this.jobDiscription,
    requiredExperience : this.requiredExperience,
    requiredSkills : this.requiredSkills
    })
  }


  createControls() {
    this.jobTitle = new FormControl('', Validators.required)
    this.jobType = new FormControl('', Validators.required)
    this.jobCategory = new FormControl('', Validators.required)
    this.jobDiscription = new FormControl('', Validators.required)
    this.requiredExperience = new FormControl()
    this.requiredSkills = new FormControl('', Validators.required)
  }


  constructor(private service : JobdetailService, private router : Router, private loggedService : LoggeduserService) {
    this.types = ["Full Time", "Part Time", "Contract", "Internship", "Co-op"];
    this.categories = ["accounting", "finance", "sales", "marketing", 
            "information technology", "engineering"] 
    this.service.getAllJobs().subscribe(data => {
      this.jobs = data;
    })
  }

  ngOnInit(): void {
    this.createControls();
    this.createForm();
  }

  onSubmit() {
    this.isFormSubmitted = true;
    if (this.jobTitle.value == null || this.jobType.value == null || this.jobCategory.value == null || this.jobDiscription.value == null || this.requiredSkills.value == null) {
      this.message = "Job was not added, Please enter valid details!"
    } else {
      this.job = {
          jobId : this.updatedJob.jobId,
          employerId : this.loggedService.id,
          companyName : 'cgi',
          postDate : this.updatedJob.postDate,
          jobTitle : this.jobTitle.value,
          jobType : this.jobType.value,
          jobCategory : this.jobCategory.value,
          jobDiscription : this.jobDiscription.value,
          requiredExperience : this.requiredExperience.value,
          requiredSkills : this.requiredSkills.value
      };
      this.service.updateJob(this.job).subscribe((data) => {
      console.log(data);
      this.message = 'Job was updated successfully'
      this.router.navigate(['portal'])  
      this.onCancel();
      }, (err) => {
        console.log(err);
        this.message = 'ERROR, Job was not updated'
      })
    }
  }
  onCancel(){
    this.canceled.emit(true);
  }
}