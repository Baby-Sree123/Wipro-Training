import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Course } from '../../types'; // Your course interface/type
import { Courseservice } from '../../service/course-service';

@Component({
  selector: 'app-view-course',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-course.html',
  styleUrls: ['./view-course.css']
})
export class ViewCourse implements OnInit {
  courses: Course[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private readonly courseService: Courseservice,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadCourses();
  }
loadCourses() {
  this.courseService.getCourses().subscribe({
    next: (data: Course[]) => {
      if (Array.isArray(data)) {
        this.courses = data.map(course => ({
          ...course,
          createdAt: course.createdAt || new Date().toISOString()  // <-- add fallback here
        }));
        this.cdr.detectChanges();
      }
      this.isLoading = false;
    },
    error: (err: any) => {
      this.errorMessage = 'Failed to fetch courses.';
      console.error(err);
      this.isLoading = false;
    }
  });
}



  deleteCourse(id: number | undefined) {
    if (!id) return;
    if (confirm('Are you sure you want to delete this course?')) {
      this.courseService.deleteCourse(id).subscribe({
        next: () => {
          alert('Course deleted successfully');
          this.loadCourses();
        },
        error: (err: any) => {
          console.error(err);
          alert('Failed to delete course!');
        }
      });
    }
  }

  editCourse(id: number | undefined) {
    if (!id) return;
    this.router.navigate(['/edit-course', id]);
  }
}
