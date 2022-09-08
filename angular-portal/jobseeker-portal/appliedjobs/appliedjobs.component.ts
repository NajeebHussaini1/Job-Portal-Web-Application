import { Component, OnInit } from '@angular/core';
import { AppliedJobs } from 'src/app/Model/appliedjob';
import { Job } from 'src/app/Model/job';
import { AppliedJobService } from 'src/app/Shared/appliedJobs.service';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';
import { LoggeduserService } from 'src/app/Shared/loggeduser.service';


@Component({
  selector: 'app-appliedjobs',
  templateUrl: './appliedjobs.component.html',
  styleUrls: ['./appliedjobs.component.css']
})
export class AppliedjobsComponent implements OnInit {
  headers=['Company Name','Job Role','Job Type','Experience',''];
  allAppliedJobs:AppliedJobs[] = [];
  myJobs:AppliedJobs[] = [];
  allJobs : Job[] =[];
  public jobs : Job[] = [];
  errormsg: string = "You Have Not Applied to any Jobs";
  successmsg:boolean = true;
  constructor(private appliedjobsservice:AppliedJobService, private loggedService : LoggeduserService, private jobsService : JobdetailService) { 
    this.appliedjobsservice.getAppliedJobs().subscribe((data) => {
      if (data.length == 0) {
        this.successmsg = false
      }
      for (let index = 0; index < data.length; index++) {
        if(data[index].candidateID == this.loggedService.id) {
          this.myJobs.push(data[index])
        }
      }
      console.log(this.myJobs)
      console.log(this.myJobs.length)
      this.jobsService.getAllJobs().subscribe(data2 => {
        for (let k = 0; k < this.myJobs.length; k++) {
          for (let i = 0; i < data2.length; i++) {
            if(data2[i].jobId == this.myJobs[k].jobID) {
              console.log(data2[i])
              this.jobs.push(data2[i])
            }
            
          }
          console.log(this.jobs)
          console.log(this.jobs.length)
          
        }
      })
    })
  }

  getAppliedJobs() {
    
  }

  getAllJobs() {


  }
  ngOnInit() : void {

  }

}

/* console.log(data2);
        console.log(data2.length);
        for (let index = 0; index < data2.length; index++) {
          this.myJobs.forEach(item =>{
          if (data[index].jobID == item.jobID) {
            console.log(item);
           }
           }); */
        
          