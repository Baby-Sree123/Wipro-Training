import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-edit-component',
  imports: [FormsModule,CommonModule],
  templateUrl: './edit-component.html',
  styleUrl: './edit-component.css'
})
export class EditComponent implements OnInit {

  user: User = {
    name: '',
    username: '',
    email: '',
    phone: '',
    password: '',
    address: ''
  };

  userId!: number;
  errorMessage = '';
  isLoading = true;
  successMessage = '';

    constructor(
    public readonly route: ActivatedRoute,
    public readonly router: Router,
    public readonly authService: AuthService,
    public readonly cdr:ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
    if (!this.userId) {
      this.errorMessage = 'Invalid user ID';
      this.isLoading = false;
      return;
    }
    this.loadUser();
  }

  loadUser() {
    this.isLoading = true;
    this.authService.getUser(this.userId).subscribe({
      next: (res: User) => {
        this.user = res;
        this.isLoading = false;
  this.cdr.detectChanges();

      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Unable to load user';
        this.isLoading = false;

        if (err.status === 401 || err.status === 403) {
          this.authService.logout();
          this.router.navigate(['/login']);
        }
      }
    });
  }

  updateUser() {
    // Use the same approach as getUser(), i.e., include JWT in header
    this.isLoading = true;
    this.authService.updateUser(this.userId, this.user).subscribe({
      next: () => {
        this.successMessage = 'User updated successfully!';
        this.isLoading = false;
        setTimeout(() => this.router.navigate(['/profile']), 1500);
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Update failed';
        this.isLoading = false;

        if (err.status === 401 || err.status === 403) {
          this.authService.logout();
          this.router.navigate(['/login']);
        }
      }
    });
  this.cdr.detectChanges();

  }

}
