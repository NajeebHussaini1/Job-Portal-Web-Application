import { Component, ElementRef, EventEmitter, HostListener, Input, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/Model/job';
import { JobdetailService } from 'src/app/Shared/jobdetail.service';

@Component({
  selector: 'app-all-job-detail',
  templateUrl: './all-job-detail.component.html',
  styleUrls: ['./all-job-detail.component.css']
})
export class AllJobDetailComponent implements OnInit {

  @ViewChild('sticky') menuElement: ElementRef;

  sticky: boolean = false;
  elementPosition: any;
  
  @Input() job : Job;

  constructor(private service : JobdetailService, private router: Router) { 
    
  }

  ngOnInit(): void {
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

}
