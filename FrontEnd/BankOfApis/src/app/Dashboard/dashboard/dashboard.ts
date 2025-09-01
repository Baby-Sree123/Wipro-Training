import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProfileComponent } from '../../auth/profile/profile/profile';
import { EditComponent } from '../../auth/profile/edit-component/edit-component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
   standalone: true,
  imports: [CommonModule,FormsModule,ProfileComponent,EditComponent],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css']
})
export class Dashboard {

  
  constructor(private readonly router: Router) {}

  navigateToRegister() {
    this.router.navigate(['/register']);
  }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}
