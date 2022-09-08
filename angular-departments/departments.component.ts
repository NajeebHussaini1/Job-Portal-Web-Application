import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  Departments=[
    {'id': 1,  'name': 'Accounting' , 'image':'../../assets/Accounting.jfif'},
  {'id': 2,  'name': 'Finance' ,  'image':'../../assets/Finance.jpg'},
  {'id': 3,  'name': 'Marketing' ,  'image':'../../assets/marketing.jfif'},
  {'id': 4,  'name': 'Technology' ,  'image':'../../assets/Technology.jfif'},
  {'id': 5,  'name': 'Sales' ,  'image':'../../assets/Sales.jfif'},

]
}
