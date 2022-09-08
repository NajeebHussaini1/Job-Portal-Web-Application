import { Component, Input, OnInit } from '@angular/core';
import { Job } from 'src/app/Model/job';

@Component({
  selector: 'app-all-job-item',
  templateUrl: './all-job-item.component.html',
  styleUrls: ['./all-job-item.component.css']
})
export class AllJobItemComponent implements OnInit {

  
  @Input() job: Job;
  jobId: number;
  

  constructor() {}

  ngOnInit() {
  }
}
