import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Userservice } from '../../service/userservice';
import { User } from '../../types';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-user',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-user.html',   // Angular CLI convention
  styleUrls: ['./view-user.css']     // Angular CLI convention
})
export class ViewUser implements OnInit {

  users: User[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private readonly userService: Userservice,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.isLoading = true;
    this.errorMessage = '';

    console.log("Loading Users...");
    this.userService.getUsers().subscribe({
      next: (data) => {
        console.log("API Response: ", data, Array.isArray(data));
        if (Array.isArray(data)) {
          this.users = data;
          this.cdr.detectChanges();
          console.log("Assigned users length:", this.users.length);
        } else {
          this.errorMessage = 'Invalid data format received.';
        }
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch data.';
        this.isLoading = false;
        console.error(err);
      }
    });
  }

  deleteUser(id?: number): void {
    if (id === undefined) {
      alert("Invalid user ID.");
      return;
    }

    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUser(id).subscribe({
        next: () => {
          alert('User deleted successfully.');
          this.loadUsers();
        },
        error: (err) => {
          console.error(err);
          alert('Failed to delete user.');
        }
      });
    }
  }

  editUser(id?: number): void {
    if (id === undefined) {
      alert("Invalid user ID.");
      return;
    }
    console.log("Navigating to edit user with ID:", id);
    this.router.navigate(['/edit-user', id]);
  }
}
