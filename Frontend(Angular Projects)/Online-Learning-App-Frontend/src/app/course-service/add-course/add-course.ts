import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Courseservice } from '../../service/course-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-course',
  standalone: true,           
  imports: [FormsModule],
  templateUrl: './add-course.html',
  styleUrls: ['./add-course.css']   
})
export class AddCourse {
  course = {
    title: '',
    description: '',
    duration: '',
    createdAt: ''
  };

  message = '';

  constructor(private courseService: Courseservice, private router: Router) {}

  onSubmit() {
    console.log("Submitting course:", this.course);

    this.courseService.addCourse(this.course).subscribe({
      next: (response: any) => {
        console.log("Course saved:", response);
        this.message = "Course added successfully!";
        this.router.navigate(['/course']);   
      },
      error: (err) => {
        console.error("Error while saving course:", err);
        this.message = `Error adding course! (status ${err.status})`;
      }
    });
  }
}