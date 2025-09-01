import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Account } from '../types';
import { AccountService } from '../account-service';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule, CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-all-user-accounts',
  imports: [FormsModule,CommonModule,CurrencyPipe,RouterModule],
  templateUrl: './all-user-accounts.html',
  styleUrls: ['./all-user-accounts.css']
})
export class AllUserAccounts implements OnInit{

  accounts: Account[] = [];
  isLoading = true;
  errorMessage = '';

  constructor(private readonly accountService: AccountService, private readonly router: Router, private readonly cdr:ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadAccounts();
    console.log('all loaded');
  }

  loadAccounts(): void {
    this.isLoading = true;
    this.accountService.getAccounts().subscribe({
      next: (res) => {
        this.accounts = res;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Unable to fetch accounts.';
        this.isLoading = false;
      }
    });
  }

  viewTransactions(accountId: number) {
    this.router.navigate(['/account-transactions', accountId]);
  }

  deleteAccount(accountId: number) {
    if (!confirm('Are you sure you want to delete this account?')) return;

    this.accountService.deleteAccount(accountId).subscribe({
      next: () => this.loadAccounts(),
      error: (err) => {
        console.error(err);
        alert('Failed to delete account.');
        this.cdr.detectChanges();
      }
    });
    
  }

}
