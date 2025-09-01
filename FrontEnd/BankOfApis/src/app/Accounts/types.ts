
export interface Account {
  accountId: number;
  accountType: string;
  accountBalance: number;
  userId: number;
  secretPassword: string;
}
export interface Transaction {
  transactionId?: number;
  fromAccountId: number;
  toAccountId: number;
  amount: number;
  transactionType: string;  
  dateTransaction: string;  
  userId: number;
}

