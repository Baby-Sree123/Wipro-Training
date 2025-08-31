import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../user.model';
import { AuthService } from '../../auth.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [FormsModule,CommonModule,RouterModule],
  templateUrl: './register.html',
  styleUrls: ['./register.css']
})
export class Register {

  user: User = {
    name: '',
    username: '',
    email: '',
    phone: '',
    password: '',
    address: ''
  };

   errorMessage: string = '';
  successMessage: string = '';

  constructor(private readonly authService: AuthService, private readonly router: Router) { }
register() {
    this.authService.register(this.user).subscribe({
      next: () => {
        this.successMessage = 'Registration successful! Redirecting to login...';
        this.errorMessage = '';
        setTimeout(() => this.router.navigate(['/login']), 2000);
      },
      error: (err) => {
        this.errorMessage = 'Registration failed. Please try again.';
        this.successMessage = '';
        console.error(err);
      }
    });
  }

}
