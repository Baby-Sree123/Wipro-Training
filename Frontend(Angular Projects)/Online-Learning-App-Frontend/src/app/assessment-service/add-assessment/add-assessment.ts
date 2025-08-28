import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Assessmentservice } from '../../service/assessment-service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-assessment',
  standalone: true,                     
  imports: [FormsModule],
  templateUrl: './add-assessment.html',
  styleUrls: ['./add-assessment.css']  
})
export class AddAssessment implements OnInit {  

  assessment = {
    title: '',
    description: '',
    totalMarks: 0,
    deadline: '',
    createdAt: ''
  };

  message = '';
  selectedCourseId!: number;

  constructor(
    private assessmentService: Assessmentservice,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    const idFromRoute = this.route.snapshot.paramMap.get('id');
    this.selectedCourseId = idFromRoute ? +idFromRoute : 0;  // safely convert to number
    console.log('Course ID from route:', this.selectedCourseId);
  }

  onSubmit() {
    if (!this.selectedCourseId || this.selectedCourseId <= 0) {
      alert('Invalid course ID. Cannot add assessment.');
      return;
    }

    console.log('Submitting assessment:', this.assessment, 'for course:', this.selectedCourseId);

    this.assessmentService.addAssessment(this.selectedCourseId, this.assessment).subscribe({
      next: (response) => {
        console.log('Assessment saved:', response);
        this.message = 'Assessment added successfully!';
        this.router.navigate(['/assessments']);
      },
      error: (err) => {
        console.error('Error while saving assessment:', err);
        this.message = 'Error adding assessment!';
      }
    });
  }
}
