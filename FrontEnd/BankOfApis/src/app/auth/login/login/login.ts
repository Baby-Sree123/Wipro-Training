import { ChangeDetectorRef, Component } from '@angular/core';
import { AuthService } from '../../auth.service';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule,CommonModule,RouterModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login {

   username: string = '';
  password: string = '';
  errorMessage: string = '';

   constructor(private readonly authService: AuthService, private readonly router: Router,private readonly cdr: ChangeDetectorRef) { }

     login() {
    const credentials = { username: this.username, password: this.password };

    this.authService.login(credentials).subscribe({
      next: (token: string) => {
         console.log('Login token:', token);
         console.log('Navigating to /allaccounts');
        this.authService.setToken(token);
        this.router.navigate(['/postdashboard']);
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = 'Invalid username or password';
        console.error(err);
        this.cdr.detectChanges();
      }
    });

  }}
