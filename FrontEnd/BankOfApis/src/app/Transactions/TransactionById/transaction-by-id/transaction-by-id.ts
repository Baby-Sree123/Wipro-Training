import { ChangeDetectorRef, Component } from '@angular/core';
import { Transaction } from '../../types';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { TransactionService } from '../../transaction-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-transaction-by-id',
  imports: [FormsModule,CommonModule,RouterModule],
  templateUrl: './transaction-by-id.html',
  styleUrl: './transaction-by-id.css'
})
export class TransactionById {
  transaction!: Transaction;
  isLoading = false;
  errorMessage = '';

  constructor(
    private readonly txnService: TransactionService,
    private readonly cdr: ChangeDetectorRef,
    private readonly route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!id) {
      this.errorMessage = 'Invalid transaction ID';
      return;
    }

    this.isLoading = true;
    this.txnService.getTransactionById(id).subscribe({
      next: (txn) => {
        this.transaction = txn;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to load transaction';
        this.isLoading = false;
        this.cdr.detectChanges();
      }
    });
  }


}
