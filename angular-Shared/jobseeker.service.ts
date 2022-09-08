import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobseekerService {

  headers;
  constructor(private http : HttpClient) {
    this.headers = new HttpHeaders({'Content-Type':'application/json'});
  }

  addJobSeeker(jobseeker) : Observable<any> {
    return this.http.post('http://10.0.0.198:8011/jobseeker-ws/jobseeker', jobseeker, {headers: this.headers});
 }

 loginJobSeeker(jobseeker) : Observable<any> {
  return this.http.post('http://10.0.0.198:8011/jobseeker-ws/login', jobseeker, {headers: this.headers});
 }

 getJobSeekers() : Observable<any> {
   return this.http.get('http://10.0.0.198:8011/jobseeker-ws/api/v1/jobseekers');
 }

 deleteJobSeekers(id) :  Observable<any> {
    return this.http.delete('http://10.0.0.198:8011/jobseeker-ws/api/v1/delete/' + id);
 }

 updateJobSeekers(update) : Observable<any> {
   return this.http.put('http://10.0.0.198:8011/jobseeker-ws/api/v1/update', update);
 }

}
