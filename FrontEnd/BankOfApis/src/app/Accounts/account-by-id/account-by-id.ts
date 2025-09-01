import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from '../account-service';
import { Account } from '../types';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-account-by-id',
  imports: [FormsModule,CommonModule],
  templateUrl: './account-by-id.html',
  styleUrl: './account-by-id.css'
})
export class AccountById implements OnInit{


  
  accountId!: number;
  account?: Account;
  errorMessage: string = '';
  isLoading: boolean = false;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly accountService: AccountService,
    private readonly cdr:ChangeDetectorRef
  ) {}

  ngOnInit() {
    // Get ID from route param
    this.accountId = +this.route.snapshot.paramMap.get('id')!;
    this.loadAccount();
  }

  loadAccount() {
    this.isLoading = true;
    this.accountService.getAccountById(this.accountId).subscribe({
      next: (data) => {
        this.account = data;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to load account.';
        this.isLoading = false;
        this.cdr.detectChanges();
      }
    });
  }
}
