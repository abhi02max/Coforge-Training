import { Component } from '@angular/core';

@Component({
  selector: 'app-student',
  imports: [],
  templateUrl: './student.html',
  styleUrl: './student.css',
})
export class Student {
  studentPhoto: string = 'girl.jpeg';
  name: string = 'Ananya';
  course: string = 'Computer Science Engineering';
  college: string = 'National Institute of Technology';
}
