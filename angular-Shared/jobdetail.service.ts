import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class JobdetailService {

  headers;
  constructor(private http : HttpClient) {
    this.headers = new HttpHeaders({'Content-Type':'application/json'});
  }

  addJob(jobDetail) : Observable<any> {
    return this.http.post('http://10.0.0.198:8011/jobs-ws/jobportal/postjob', jobDetail, {headers: this.headers});
    //return this.http.post('http://192.168.0.19:8040/jobportal/postjob', jobDetail, {headers: this.headers});
  }

  getAllJobs() : Observable<any> {
    return this.http.get('http://10.0.0.198:8011/jobs-ws/jobportal/getAllJobs');
    //return this.http.get('http://192.168.0.19:8040/jobportal/getAllJobs');
  }

  getJobsbyId(id) : Observable<any> {
    return this.http.get('http://10.0.0.198:8011/jobs-ws/jobportal/search/' + id);
    //return this.http.get('http://192.168.0.19:8040/jobportal/search/' + id);
  }

  deleteJob(id) :  Observable<any> {
    return this.http.delete('http://10.0.0.198:8011/jobs-ws/jobportal/delete/' + id);
    //return this.http.delete('http://192.168.0.19:8040/jobportal/delete/' + id);
  }

  updateJob(update) : Observable<any> {
    return this.http.put('http://10.0.0.198:8011/jobs-ws/jobportal/update', update);
    //return this.http.put('http://192.168.0.19:8040/jobportal/update', update);
  }
 
  
}



  
