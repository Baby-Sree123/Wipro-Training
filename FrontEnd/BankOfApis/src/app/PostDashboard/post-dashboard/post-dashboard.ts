import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-post-dashboard',
  imports: [RouterModule],
  templateUrl: './post-dashboard.html',
  styleUrls: ['./post-dashboard.css']
})
export class PostDashboard implements OnInit{
   userName: string = ''; 
    ngOnInit(): void {
    const storedName = localStorage.getItem('username');
    if (storedName) {
      this.userName = storedName;
    }
  }

}
