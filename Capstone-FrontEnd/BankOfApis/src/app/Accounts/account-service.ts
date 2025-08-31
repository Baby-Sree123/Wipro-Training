import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account, Transaction } from './types';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private readonly baseUrl = 'http://localhost:2222/api/accounts';
  
   constructor(private readonly http: HttpClient) {}

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwt');
    return new HttpHeaders().set('Authorization', `Bearer ${token}`);
  }

  
  // Get all accounts for current user
  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(this.baseUrl, { headers: this.getHeaders() });
  }

  // Get account by ID
  getAccountById(accountId: number): Observable<Account> {
    return this.http.get<Account>(`${this.baseUrl}/${accountId}`, { headers: this.getHeaders() });
  }

  // Get transactions for an account
  getAccountTransactions(accountId: number): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.baseUrl}/${accountId}/statements`, { headers: this.getHeaders() });
  }

  // Create new account
  createAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(this.baseUrl, account, { headers: this.getHeaders() });
  }

  // Update existing account
  updateAccount(accountId: number, account: Account): Observable<Account> {
    return this.http.put<Account>(`${this.baseUrl}/${accountId}`, account, { headers: this.getHeaders() });
  }

  // Delete account
  deleteAccount(accountId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${accountId}`, { headers: this.getHeaders() });
  }

}
