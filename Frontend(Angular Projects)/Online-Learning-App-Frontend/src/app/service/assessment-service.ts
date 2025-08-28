import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Assessment } from '../types';

@Injectable({
  providedIn: 'root'
})
export class Assessmentservice {

  private apiUrl: string = "http://localhost:8084/api/assessments";

  // Basic Auth credentials (adjust if necessary)
  private username = 'admin';
  private password = 'admin1234';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const basicAuth = 'Basic ' + btoa(this.username + ':' + this.password);
    return new HttpHeaders({
      Authorization: basicAuth,
      'Content-Type': 'application/json'
    });
  }

 addAssessment(courseId: number, assessment: any) {
  const url = `http://localhost:8084/api/assessments/course/${courseId}`;
  return this.http.post(url, assessment);
}

  getAssessments(): Observable<Assessment[]> {
    return this.http.get<Assessment[]>(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  deleteAssessment(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`, {
      headers: this.getAuthHeaders(),
      responseType: 'text' as 'json'
    });
  }

  getAssessmentById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  updateAssessment(id: number, assessment: Assessment): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, assessment, { headers: this.getAuthHeaders() });
  }
}
