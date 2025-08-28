import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";
import { User } from "../types";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class Userservice {
  private apiUrl: string = "http://localhost:8081/api/users";

  constructor(private http: HttpClient) {}

  addUser(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, user);
  }

  getUsers(): Observable<User[]> {
  return this.http.get<any[]>(this.apiUrl).pipe(
    map((users: any[]) =>
      users.map(user => ({
        id: user.id,
        name: user.uname, 
        email: user.email || '',
        password: user.pwd, // map pwd to password
        role: user.role
      }))
    )
  );
}


  deleteUser(id: number | undefined): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  UpdateUser(id: number, user: User): Observable<User> {
  return this.http.put<User>(`${this.apiUrl}/${id}`, user);
}

}
