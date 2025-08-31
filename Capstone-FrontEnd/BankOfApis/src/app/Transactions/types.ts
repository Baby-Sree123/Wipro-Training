export interface Transaction {
  transactionId: number;
  fromAccountId: number;
  toAccountId: number;
  amount: number;
  transactiontype: string;
  date_transaction: string; 
  userId: number;
}
