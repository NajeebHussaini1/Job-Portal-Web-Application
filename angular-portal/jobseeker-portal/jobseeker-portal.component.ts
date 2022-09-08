import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-jobseeker-portal',
  templateUrl: './jobseeker-portal.component.html',
  styleUrls: ['./jobseeker-portal.component.css']
})
export class JobseekerPortalComponent implements OnInit {



  constructor(private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.router.navigate(['resume']);
  }
  onApply(){
   this.router.navigate(['applyjobs'])
  }

  onAppliedJobs(){
    this.router.navigate(['appliedjobs'])
   }

}
