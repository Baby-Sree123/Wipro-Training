import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { TransactionService } from '../../transaction-service';
import { Transaction } from '../../types';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-all-transactions',
   imports: [CommonModule, RouterModule,FormsModule],
  templateUrl: './all-transactions.html',
  styleUrls: ['./all-transactions.css']   
})
export class AllTransactions implements OnInit {

  transactions: Transaction[] = [];
  isLoading: boolean = false;  
  errorMessage: string = '';    

  constructor(private readonly transactionService: TransactionService,private readonly cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.fetchTransactions();
  }

  fetchTransactions(): void {
    this.isLoading = true;
    this.transactionService.getAllTransactions().subscribe({
      next: (data) => {
        this.transactions = data;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = 'Failed to load transactions.';
        console.error(err);
        this.isLoading = false;
        this.cdr.detectChanges();
      }
    });
  }

  deleteTransaction(id: number): void {
  this.transactionService.deleteTransaction(id).subscribe({
    next: () => {
      this.transactions = this.transactions.filter(txn => txn.transactionId !== id);
      this.cdr.detectChanges();
    },
    error: (err) => {
      console.error('Delete failed', err);
      this.cdr.detectChanges();
    }
  });
}}