import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployerService {

  headers;
  constructor(private http : HttpClient) {
    this.headers = new HttpHeaders({'Content-Type':'application/json'});
   }

   addEmployer(employer) : Observable<any> {
      return this.http.post('http://10.0.0.198:8011/employer-ws/employer', employer, {headers: this.headers});
   }

   loginEmployer(employer) : Observable<any> {
    return this.http.post('http://10.0.0.198:8011/employer-ws/login', employer, {headers: this.headers});
  }

   getEmployers() : Observable<any> {
     return this.http.get('http://10.0.0.198:8011/employer-ws/api/v1/employers');
   }

   deleteEmployer(id) :  Observable<any> {
      return this.http.delete('http://10.0.0.198:8011/employer-ws/api/v1/delete/' + id);
   }

   updateEmployer(update) : Observable<any> {
     return this.http.put('http://10.0.0.198:8011/employer-ws/api/v1/update', update);
   }
}
