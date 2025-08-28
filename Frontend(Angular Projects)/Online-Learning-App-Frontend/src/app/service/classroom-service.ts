import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Classroom } from '../types';

@Injectable({
  providedIn: 'root'
})
export class Classroomservice {
  
   private readonly apiUrl:string = "http://localhost:8083/api/classrooms";

   // Test credentials (make sure they match backend config)
  private readonly username = 'admin';
  private readonly password = 'admin123';

  constructor(private readonly http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const basicAuth = 'Basic ' + btoa(this.username + ':' + this.password);
    return new HttpHeaders({
      Authorization: basicAuth,
      'Content-Type': 'application/json'
    });
  }

  addClassroom(classroom: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, classroom, { headers: this.getAuthHeaders() });
  }

  getClassrooms(): Observable<Classroom[]> {
    return this.http.get<Classroom[]>(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  deleteClassroom(id: number | undefined): Observable<any> {
  return this.http.delete(`${this.apiUrl}/${id}`, {
    headers: this.getAuthHeaders(),
    responseType: 'text' as 'json' 
  });
}
  getClassroomById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  updateClassroom(id: number, classroom: Classroom): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, classroom, { headers: this.getAuthHeaders() });
  }
}