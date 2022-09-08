import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoggeduserService {

  public employerLoggedIn : boolean;
  public adminLoggedIn : boolean;
  public jobSeekerLoggedIn : boolean;
  public isLoggedIn : boolean;
  public isUserLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public id : number;
  public userName : string;
  public email : string;
  public firstName : string;
  public lastName : string;
  public companyName : string;
  public phoneNumber : string;
  public city : string;
  public province : string;
  public gender : string;
  public category : string;
  public about : string;
  public message : string;

  constructor() {
    this.employerLoggedIn = false;
    this.adminLoggedIn = false;
    this.jobSeekerLoggedIn = false;
    this.isLoggedIn = false;
   }

  loginEmployer(userId, email, companyName, category, about) {
    this.employerLoggedIn = true;
    this.adminLoggedIn = false;
    this.jobSeekerLoggedIn = false;
    this.isLoggedIn = true;
    this.id = userId;
    this.email = email;
    this.companyName = companyName;
    this.category = category;
    this.about = about;
  }

  loginAdmin(userId, firstName, lastName, email) {
    this.employerLoggedIn = false;
    this.adminLoggedIn = true;
    this.jobSeekerLoggedIn = false;
    this.isLoggedIn = true;
    this.id = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  loginJobSeeker(userId, userName, email, firstName, lastName, phoneNumber, city, province, gender) {
    this.employerLoggedIn = false;
    this.adminLoggedIn = false;
    this.jobSeekerLoggedIn = true;
    this.isLoggedIn = true;
    this.id = userId;
    this.userName = userName;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.city = city;
    this.province = province;
    this.gender = gender;
  }

  logout() {
    this.employerLoggedIn = false;
    this.adminLoggedIn = false;
    this.jobSeekerLoggedIn = false;
    this.isLoggedIn = false;
    this.id = 0;
    this.userName = "";
    this.email = "";
    this.firstName = "";
    this.lastName = "";
    this.companyName = "";
    this.phoneNumber = "";
    this.city = "";
    this.province = "";
    this.gender = "";
    this.message = "";
    this.category = "";
    this.about = ""
  }
}
