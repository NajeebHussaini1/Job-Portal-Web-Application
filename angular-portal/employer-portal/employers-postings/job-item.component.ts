import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/Model/job';

@Component({
  selector: 'app-job-item',
  templateUrl: './job-item.component.html',
  styleUrls: ['./job-item.component.css']
})
export class JobItemComponent implements OnInit {

  @Input() job: Job;
  jobId: number;
  

  constructor() {}

  ngOnInit() {
  }


}



