import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';   
import { Userservice } from '../../service/userservice';
import { Router } from '@angular/router';
import { Role } from '../../enum';

@Component({
  selector: 'app-add-user',
  imports: [FormsModule, CommonModule],   
  templateUrl: './add-user.html',
  styleUrls: ['./add-user.css']
})
export class AddUser {
  user = {
  name: '',
  email: '',
  password: '',
  role: Role.STUDENT
};

message = '';

  successMessage = '';
  errorMessage = '';

  constructor(private readonly userService: Userservice, private readonly router: Router) {}

  async onSubmit() {
    console.log("Submitting user:", this.user);
    this.userService.addUser(this.user).subscribe({
      next: (response) => {
        console.log("User saved:", response);
        this.successMessage = "User added successfully!";
        this.errorMessage = '';
        this.router.navigate(['/user']);
      },
      error: (err) => {
        console.error("Error while saving user:", err);
        this.errorMessage = "Error adding User!";
        this.successMessage = '';
      }
    });
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}
