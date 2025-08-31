import { CommonModule, DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from '../account-service';

@Component({
  selector: 'app-account-transactions',
  templateUrl: './account-transactions.html',
   imports: [CommonModule, DatePipe],
  styleUrls: ['./account-transactions.css']
})
export class AccountTransactions implements OnInit{

accountId!: number;
  transactions: any[] = [];

  constructor(private readonly route: ActivatedRoute, private readonly http: HttpClient,private readonly accountService:AccountService,private readonly cdr:ChangeDetectorRef) {}

  ngOnInit() {
    this.accountId = +this.route.snapshot.paramMap.get('id')!;
    this.loadTransactions();
    
  }

 loadTransactions() {
    this.accountService.getAccountTransactions(this.accountId).subscribe({
      next: (transactions) => {
        this.transactions = transactions;
        this.cdr.detectChanges();
      },
      
      error: (err) => console.error('Error fetching transactions', err)
     
    });
  }

  }

