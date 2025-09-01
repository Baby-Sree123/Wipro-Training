import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user.model';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly baseurl = 'http://localhost:1111/api/auth'
  constructor(private readonly http: HttpClient){}


// Register user
  register(user: any): Observable<any> {
    return this.http.post(`${this.baseurl}/register`, user);
  }

  // Login user
  login(credentials: { username: string, password: string }): Observable<string> {
  return this.http.post(`${this.baseurl}/login`, credentials, { responseType: 'text' });
}


  // Get all users (optional)
  getAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseurl}/users`);
  }

 getUser(id: number) {
  const token = this.getToken();
  if (!token) {
    console.warn('No JWT token found');
  }
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.get<User>(`${this.baseurl}/users/${id}`, { headers });
}

updateUser(id: number, user: any) {
  const token = localStorage.getItem('jwt');
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.put<any>(`${this.baseurl}/users/${id}`, user, { headers });
}

  // Delete user
  deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseurl}/users/${id}`);
  }



  // Save JWT token
  setToken(token: string) {
    localStorage.setItem('jwt', token);
  }

  // Get token
  getToken(): string | null {
    return localStorage.getItem('jwt');
  }

  // Logout user
  logout() {
    localStorage.removeItem('jwt');
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  
  getCurrentUserId(): number | null {
    const token = this.getToken();
    if (!token) return null;

    try {
      const payload = token.split('.')[1]; // JWT payload
      const decoded = JSON.parse(atob(payload));
          console.log('Decoded JWT payload:', decoded); // ✅ Add this
      return decoded.userId || decoded.id || null;
    } catch (err) {
      console.error('Invalid token', err);
      return null;
    }
  }
}
