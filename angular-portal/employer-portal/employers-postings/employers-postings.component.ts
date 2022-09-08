import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/Model/job';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';
import { LoggeduserService } from 'src/app/Shared/loggeduser.service';


@Component({
  selector: 'app-employers-postings',
  templateUrl: './employers-postings.component.html',
  styleUrls: ['./employers-postings.component.css']
})
export class EmployersPostingsComponent implements OnInit {

  jobs: Job[] = [];

  @Input()
  deletedJob :Job;
  
  
  @Output() 
  job = new EventEmitter<Job>();

  constructor(private service : JobdetailService, private router: Router, private loggedService : LoggeduserService) { 
    this.service.getAllJobs().subscribe(data => {
      console.log(data)
/*       for (let index = 0; index < data.length; index++) {
        if(data[index].employerId == this.loggedService.id) {
          this.jobs.push(data[index])
        }
      } */

      data.forEach(element => {
        if(element.employerId == this.loggedService.id) {
          this.jobs.push(element);
        }
      });
 
      /*      data.forEach(element => {
        if (data.employerId == this.loggedService.id) {
          this.jobs.push(element)
        }
      }); */
      

      //this.jobs = data
    })

  }

  ngOnInit(): void {
  }

  postJob(){
    this.router.navigate(['PostJob'])  
  }

  onSelected(job: Job) {
    this.job.emit(job);
  }

  deleteJob(job){
    console.log("Paused is clicked ", job);
    this.deletedJob = job;
    this.jobs.splice(this.jobs.indexOf(this.deletedJob), 1);
  }

}



