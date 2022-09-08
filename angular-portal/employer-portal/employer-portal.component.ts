import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Job } from 'src/app/Model/job';

@Component({
  selector: 'app-employer-portal',
  templateUrl: './employer-portal.component.html',
  styleUrls: ['./employer-portal.component.css']
})
export class EmployerPortalComponent implements OnInit {

  @Output() 
  job = new EventEmitter<Job>();

  allPosts : boolean;
  myPosts : boolean;

  constructor() { 
    this.allPosts = false;
    this.myPosts = true;
  }

  ngOnInit(): void {
  }

  allPostsSelected(){
    this.myPosts = false;
    this.allPosts = true;
  }

  myPostsSelected(){
    this.allPosts = false;
    this.myPosts = true;
  }






  

}
