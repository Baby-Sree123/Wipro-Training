import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Account } from '../types';
import { AccountService } from '../account-service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-accont',
  standalone:true,
  imports: [FormsModule,CommonModule],
  templateUrl: './create-accont.html',
  styleUrls: ['./create-accont.css']
})
export class CreateAccont  implements OnInit{
 account: Account = {
    accountId: 0,        
    accountType: '',
    accountBalance: 0,
    userId: 0,
    secretPassword: ''
  };

  isSubmitting = false;
  errorMessage: string = '';

  constructor(
    private readonly accountService: AccountService,
    private readonly router: Router,
    private readonly cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {}

  createAccount() {
    if (!this.account.accountType || !this.account.userId || !this.account.secretPassword) {
      this.errorMessage = 'Please fill all required fields!';
      return;
    }

    this.isSubmitting = true;
    this.errorMessage = '';

    this.accountService.createAccount(this.account).subscribe({
      next: () => {
        alert('Account created successfully!');
        this.router.navigate(['/allaccounts']);
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to create account.';
        this.isSubmitting = false;
        this.cdr.detectChanges();
      }
    });
  }
}