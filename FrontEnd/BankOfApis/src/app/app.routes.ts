import { Routes } from '@angular/router';
import { Login } from './auth/login/login/login';
import { Register } from './auth/register/register/register';
import { authGuard } from './auth/auth-guard';
import { EditComponent } from './auth/profile/edit-component/edit-component';
import { Dashboard } from './Dashboard/dashboard/dashboard';
import { ProfileComponent } from './auth/profile/profile/profile';
import { AllUserAccounts } from './Accounts/all-user-accounts/all-user-accounts';
import { AccountTransactions } from './Accounts/account-transactions/account-transactions';
import { CreateAccont } from './Accounts/create-accont/create-accont';
import { AccountById } from './Accounts/account-by-id/account-by-id';
import { AllTransactions } from './Transactions/AllTransactions/all-transactions/all-transactions';
import { CreateTransaction } from './Transactions/CreateTransaction/create-transaction/create-transaction';
import { UserTransactions } from './Transactions/UserTransactions/user-transactions/user-transactions';
import { TransactionById } from './Transactions/TransactionById/transaction-by-id/transaction-by-id';
import { PostDashboard } from './PostDashboard/post-dashboard/post-dashboard';


export const routes: Routes = [

   { path: '', redirectTo: 'landing', pathMatch: 'full' },
  { path: 'landing', component: Dashboard }, 
  { path: 'register', component: Register },
  { path: 'login', component: Login },
  { path: 'profile', component: ProfileComponent, canActivate: [authGuard] },
  { path: 'edit/:id', component: EditComponent, canActivate: [authGuard] },
  {path: 'allaccounts', component:AllUserAccounts},
  {path:'account-transactions/:id',component:AccountTransactions },
  {path:'create-account', component:CreateAccont},
  {path:'accounts/:id',component:AccountById},
  {path:'transactions',component:AllTransactions},
  {path:'create-transaction', component:CreateTransaction},
  {path:'user-statements',component:UserTransactions},
  {path:'transactionbyid/:id', component:TransactionById},
  {path:'postdashboard', component:PostDashboard}
];

