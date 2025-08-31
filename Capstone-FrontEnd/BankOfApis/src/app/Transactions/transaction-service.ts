import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Transaction } from './types';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
    private readonly baseUrl = 'http://localhost:3333/api/transfers';

    constructor(private readonly http: HttpClient) {}

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('jwt');
    return new HttpHeaders().set('Authorization', `Bearer ${token}`);
  }

   getUserTransactions(): Observable<Transaction[]> {
  return this.http.get<Transaction[]>(this.baseUrl, { headers: this.getHeaders() });
}

  createTransaction(txn: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(this.baseUrl, txn, { headers: this.getHeaders() });
  }

  getTransactionById(id: number): Observable<Transaction> {
    return this.http.get<Transaction>(`${this.baseUrl}/${id}`, { headers: this.getHeaders() });
  }

  getAllTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.baseUrl, { headers: this.getHeaders() });
  }

  updateTransaction(id: number, txn: Transaction): Observable<Transaction> {
    return this.http.put<Transaction>(`${this.baseUrl}/${id}`, txn, { headers: this.getHeaders() });
  }

  deleteTransaction(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`, { headers: this.getHeaders() });
  }

  getTransactionsByAccountId(accountId: number): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.baseUrl}/account/${accountId}`, { headers: this.getHeaders() });
  }
  
  
}
