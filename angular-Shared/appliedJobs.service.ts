import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppliedJobs } from '../Model/appliedjob';

@Injectable({
    providedIn: 'root'
})
export class AppliedJobService {

    headers;
    constructor(private http: HttpClient) {
        this.headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    }

    createAppliedJob(appliedJob : AppliedJobs): Observable<any> {
        return this.http.post('http://10.0.0.198:8011/appliedJobs-ws/jobs/addjob', appliedJob, { headers: this.headers });
    }

    getAppliedJobs(): Observable<any> {
        return this.http.get('http://10.0.0.198:8011/appliedJobs-ws/jobs/alljobs');
    }



    // addEmployer(employer) : Observable<any> {
    //    return this.http.post('http://10.0.0.198:8020/employer', employer, {headers: this.headers});
    // }
}