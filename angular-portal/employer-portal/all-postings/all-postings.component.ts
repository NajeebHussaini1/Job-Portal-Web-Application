import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/Model/job';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';


@Component({
  selector: 'app-all-postings',
  templateUrl: './all-postings.component.html',
  styleUrls: ['./all-postings.component.css']
})
export class AllPostingsComponent implements OnInit {

  jobs: Job[] = [];
  
  @Output() 
  job = new EventEmitter<Job>();

  constructor(private service : JobdetailService, private router: Router) { 

  }

  ngOnInit(): void {

    this.service.getAllJobs().subscribe(data => {
      console.log(data)
      this.jobs = data;
      console.log(this.jobs)
    })
  }

  onSelected(job: Job) {
    this.job.emit(job);
  }
}