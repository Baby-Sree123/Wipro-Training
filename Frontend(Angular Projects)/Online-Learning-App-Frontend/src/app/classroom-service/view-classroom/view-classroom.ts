import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Classroomservice } from '../../service/classroom-service';
import { Classroom } from '../../types';

@Component({
  selector: 'app-view-classroom',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './view-classroom.html',
  styleUrls: ['./view-classroom.css']
})
export class ViewClassroom implements OnInit {

  classrooms: Classroom[] = [];
  filteredClassrooms: Classroom[] = [];
  errorMessage = '';
  isLoading = true;
  searchText = '';

  constructor(
    private classroomService: Classroomservice,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadClassrooms();
  }

  loadClassrooms() {
    this.isLoading = true;
    this.classroomService.getClassrooms().subscribe({
      next: (data) => {
        if (Array.isArray(data)) {
          this.classrooms = data;
          this.applyFilter();
        } else {
          this.classrooms = [];
        }
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch classrooms.';
        this.isLoading = false;
        console.error(err);
      }
    });
  }

  deleteClassroom(id: number | undefined) {
    if (id === undefined) return;

    if (confirm('Are you sure to delete this classroom?')) {
      this.classroomService.deleteClassroom(id).subscribe({
        next: () => {
          alert('Classroom deleted successfully');
          this.loadClassrooms();
        },
        error: (err) => {
          console.error(err);
          alert('Failed to delete classroom');
        }
      });
    }
  }

  editClassroom(id: number | undefined) {
    if (id === undefined) return;
    this.router.navigate(['/edit-classroom', id]);
  }

  applyFilter() {
    if (!this.searchText) {
      this.filteredClassrooms = [...this.classrooms];
    } else {
      const search = this.searchText.toLowerCase();
      this.filteredClassrooms = this.classrooms.filter(c =>
        c.name.toLowerCase().includes(search) ||
        c.location.toLowerCase().includes(search) ||
        c.type.toLowerCase().includes(search)
      );
    }
  }
}
