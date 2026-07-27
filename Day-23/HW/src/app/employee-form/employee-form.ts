import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule,  NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-form.html',
  styleUrl: './employee-form.css',
})
export class EmployeeForm {
  employee = {
      id: null,
      name: '',
      department: '',
      email: '',
      salary: null,
      joiningDate: ''
    };

  // Variable to store submitted data for display
  submittedEmployee: any = null;

  // Handle Form Submission
  onSubmit(form: NgForm) {
    if (form.valid) {
      this.submittedEmployee = { ...this.employee };
    }
  }

  // Handle Form Reset
  onReset(form: NgForm) {
    form.resetForm();
    this.submittedEmployee = null;
  }
}
