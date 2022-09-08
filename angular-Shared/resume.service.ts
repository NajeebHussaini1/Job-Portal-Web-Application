import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResumeService {
headers;
  constructor(private http:HttpClient) {
    this.headers = new HttpHeaders({'Content-Type':'application/json'});
   }
   createResume(resume) : Observable<any> {
    return this.http.post('http://10.0.0.198:8011/resume-ws/api/v1/resume/create', resume, {headers: this.headers});
 }
 getAllResumes() : Observable<any> {
  return this.http.get('http://10.0.0.198:8011/resume-ws/api/v1/resumes');
}
getResumesByJobId(id) :  Observable<any> {
  return this.http.get('http://10.0.0.198:8011/resume-ws/api/v1/resume/search/{JobId}' + id);

}
getResumesByResumeId(id) :  Observable<any> {
  return this.http.get('http://10.0.0.198:8011/resume-ws/api/v1/resume/search/resumes/{ResumeId}' + id);
  


}
shortListResume(shortListedResume){
  return this.http.post('http://10.0.0.198:8011/resume-ws/api/v1/resume/shortlist',shortListedResume , {headers: this.headers});
}

getShortList() {
  return this.http.get('http://10.0.0.198:8011/resume-ws/api/v1/resume/shortlist/resumes');
}

}