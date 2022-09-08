import { ElementRef, EventEmitter, HostListener, Input, Output, ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/Model/job';
import { ApplicantserviceService } from 'src/app/Shared/applicantservice.service';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';

@Component({
  selector: 'app-job-detail',
  templateUrl: './job-detail.component.html',
  styleUrls: ['./job-detail.component.css']
})
export class JobDetailComponent implements OnInit {

  @ViewChild('stickyMenu') menuElement: ElementRef;

  sticky: boolean = false;
  applicantView : boolean;
  elementPosition: any;

  canceled : boolean;
  
  @Input()
   job : Job;

  
  
  @Output() 
  deletedJob = new EventEmitter<Job>();

  @Output() 
  updatedJob = new EventEmitter<Job>();

  @Output()
  appliedJob = new EventEmitter<Job>();

  updateView : boolean;

  constructor(private service : JobdetailService, private router: Router, private applicantService : ApplicantserviceService) { 
    this.updateView = false;
    this.applicantView = false;
  }

  ngOnInit(): void {
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
      this.deletedJob.emit(job);
    }
  }

  updateJob(job:Job){
    this.updatedJob.emit(job);
    this.updateView = true;
    this.applicantView = false;
  }

  goToApplicants(job : Job){
    console.log(job)
    this.applicantService.jobId = job.jobId
    this.appliedJob.emit(job);
    this.applicantView = !this.applicantView
    this.router.navigate(['applicants'])
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

  onCancelClick(canceled){
    console.log(canceled);
    this.canceled = canceled;
    this.updateView = false;
    this.canceled = false;
  }

}
