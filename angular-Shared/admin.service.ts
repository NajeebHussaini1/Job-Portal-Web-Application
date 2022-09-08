import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  headers;
  constructor(private http : HttpClient) {
    this.headers = new HttpHeaders({'Content-Type':'application/json'});
   }

  addAdmin(admin) : Observable<any> {
    return this.http.post('http://10.0.0.198:8011/admin-ws/admin', admin, {headers: this.headers});
 }

 loginAdmin(admin) : Observable<any> {
  return this.http.post('http://10.0.0.198:8011/admin-ws/login', admin, {headers: this.headers});
}

 getAdmins() : Observable<any> {
   return this.http.get('http://10.0.0.198:8011/admin-ws/api/v1/admins');
 }

 deleteAdmin(id) :  Observable<any> {
    return this.http.delete('http://10.0.0.198:8011/admin-ws/api/v1/delete/' + id);
 }

 updateAdmin(update) : Observable<any> {
   return this.http.put('http://10.0.0.198:8011/admin-ws/api/v1/update', update);
 }
}
