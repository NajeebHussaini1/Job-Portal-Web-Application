import { Component, ElementRef, EventEmitter, HostListener, OnInit, Output, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Job } from 'src/app/Model/job';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';
import { LoggeduserService } from 'src/app/Shared/loggeduser.service';

@Component({
  selector: 'app-admin-portal',
  templateUrl: './admin-portal.component.html',
  styleUrls: ['./admin-portal.component.css']
})
export class AdminPortalComponent implements OnInit {
  @ViewChild('stickyMenu') menuElement: ElementRef;
  jobs: Job[] = [];

  sticky: boolean = false;
  updateView : boolean;
  elementPosition: any;

  @Output() 
  deletedJob = new EventEmitter<Job>();

  updatedJob : Job;

  @Output()
  appliedJob = new EventEmitter<Job>();
  
  
  job : Job;

  canceled : boolean;

  myform : FormGroup;
  jobTitle : FormControl;
  jobType : FormControl;
  jobCategory : FormControl;
  jobDiscription : FormControl;
  requiredExperience : FormControl;
  requiredSkills : FormControl;
  isFormSubmitted : boolean = false;
  message : string;
  types : string[];
  categories : string[]; 

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

  constructor(private service : JobdetailService, private router: Router, private loggedService : LoggeduserService) { 
    this.service.getAllJobs().subscribe(data => {
      console.log(data)
      this.jobs = data
    })
    this.updateView = false;
    this.types = ["Full Time", "Part Time", "Contract", "Internship", "Co-op"];
    this.categories = ["accounting", "finance", "sales", "marketing", 
            "information technology", "engineering"] 

  }

  ngOnInit(): void {
    this.createControls();
    this.createForm();
  }

  onSelected(job: Job) {
    this.job=job;
  }

  deleteJob(job){
    if(confirm("Are you sure you want to delete "+ job.jobTitle)) {
      this.service.deleteJob(job.jobId).subscribe(data => {
        console.log(data);
        console.log("job deleted!");
        this.router.navigate(['portal']);
      }, err => {
        console.log(err);
      });
    }
  }

  updateJob(job:Job){
    this.updatedJob = job;
    this.updateView = true;
  }

  ngAfterViewInit(){
    this.elementPosition = this.menuElement.nativeElement.offsetTop;
  }

  @HostListener('window:scroll', ['$event'])
    handleScroll(){
      const windowScroll = window.pageYOffset;
      if(windowScroll >= this.elementPosition){
        this.sticky = true;
      } else {
        this.sticky = false;
      }
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
        }, (err) => {
          console.log(err);
          this.message = 'ERROR, Job was not updated'
        })
      }
    }
    onCancel(){
      this.canceled = true;
      this.updateView = false;
      this.canceled = false;
    }

}



