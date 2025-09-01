import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../../user.model';
import { AuthService } from '../../auth.service';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.html',
  styleUrls: ['./profile.css'],
  standalone: true,
  imports: [FormsModule, CommonModule,RouterModule]
})
export class ProfileComponent implements OnInit {

  user: User | null = null;
  errorMessage = '';
  isLoading = true;

  constructor(private readonly authService: AuthService, private readonly router: Router, private cdr:ChangeDetectorRef) {}

  ngOnInit(): void {
    const userId = this.authService.getCurrentUserId();

    if (!userId) {
       this.errorMessage = 'Session expired. Please login again.';
        this.isLoading = false;
    this.authService.logout();
      this.router.navigate(['/login']);
      return;

    }
    this.loadUser(userId);
  }

loadUser(userId: number) {
  this.isLoading = true; 

  this.authService.getUser(userId).subscribe({
    next: (res: User) => {
      console.log('API Response:', res);
      
      this.user = res;
      
      this.isLoading = false;
      this.cdr.detectChanges();
    },
    error: (err) => {
      console.error('API Error:', err);
      this.errorMessage = 'Unable to load profile.';
      this.isLoading = false;

      // Handle unauthorized access
      if (err.status === 401 || err.status === 403) {
        this.authService.logout();
        this.router.navigate(['/login']);

      }
       this.cdr.detectChanges();
    }
  });
}
}
