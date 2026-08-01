import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-component',
  imports: [CommonModule],
  templateUrl: './employee-component.html',
  styleUrl: './employee-component.css',
})
export class EmployeeComponent {
  employeeId: number = 101;
  name: string = 'Rahul Sharma';
  department: string = 'Development';
  salary: number = 65000;
}
