import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Transaction } from '../../types';
import { TransactionService } from '../../transaction-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-transactions',
  imports: [FormsModule,CommonModule],
  templateUrl: './user-transactions.html',
  styleUrl: './user-transactions.css'
})
export class UserTransactions implements OnInit {

transactions: Transaction[] = [];
  isLoading = false;
  errorMessage = '';

  constructor(private readonly txnService: TransactionService, private readonly cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.isLoading = true;
    this.txnService.getUserTransactions().subscribe({
      next: (data) => {
        this.transactions = data;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to load transactions.';
        this.isLoading = false;
        this.cdr.detectChanges();
      }
    });
  }
}