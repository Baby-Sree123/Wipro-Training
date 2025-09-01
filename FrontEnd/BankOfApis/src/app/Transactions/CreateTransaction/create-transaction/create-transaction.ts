import { ChangeDetectorRef, Component } from '@angular/core';
import { TransactionService } from '../../transaction-service';
import { Router } from '@angular/router';
import { Transaction } from '../../types';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-create-transaction',
  imports: [FormsModule,CommonModule],
  templateUrl: './create-transaction.html',
  styleUrls: ['./create-transaction.css']
})
export class CreateTransaction {
   transaction: Partial<Transaction> = {
    fromAccountId: 0,
    toAccountId: 0,
    amount: 0,
    transactiontype: ''
    // userId and date_transaction will come automatically from backend
  };


  constructor(
    private readonly txnService: TransactionService,
    public readonly router: Router,
    private readonly cdr:ChangeDetectorRef
  ) {}

onSubmit() {
  this.txnService.createTransaction(this.transaction as Transaction).subscribe({
    next: () => {
      alert('Transaction created successfully!');
      this.router.navigate(['/transactions']);
      this.cdr.detectChanges();
    },
    error: (err) => {
      console.error(err);
      alert('Error creating transaction');
      this.cdr.detectChanges();
    }
  });
}

}
