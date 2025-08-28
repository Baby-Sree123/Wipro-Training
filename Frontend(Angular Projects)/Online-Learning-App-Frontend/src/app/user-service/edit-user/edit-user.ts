import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Userservice } from '../../service/userservice';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Role } from '../../enum';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.html',
  styleUrls: ['./edit-user.css'],
  standalone: true,
  imports: [FormsModule, CommonModule]
})
export class EditUser implements OnInit {
  user: User = {
    id: 0,
    name: '',
    email: '',
    password: '',
    role: Role.TEACHER
  };

  id!: number;
  message: string = '';

  constructor(
    private readonly route: ActivatedRoute,
    private readonly userService: Userservice,
    private readonly router: Router,
    private readonly cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.params['id']);
    this.loadUser();
  }

  loadUser() {
    this.userService.getUserById(this.id).subscribe({
      next: (data) => {
        this.user = {
          id: data.id,
          name: data.name,
          email: data.email || '',
          password: data.password,
          role: data.role
        };
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Failed to load user:', err);
        this.message = 'Failed to load user';
      }
    });
  }

  onSubmit() {
    this.userService.UpdateUser(this.id, this.user).subscribe({
      next: () => {
        alert('User updated successfully');
        this.router.navigate(['/user']);
      },
      error: (err) => {
        console.error(err);
        alert('Failed to update user!');
      }
    });
  }
}
