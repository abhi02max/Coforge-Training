import { Component, signal } from '@angular/core';
//import { RouterOutlet } from '@angular/router';
import { EmployeeComponent } from './employee-component/employee-component';
import { Student } from './student/student';
import { Product } from './product/product';
import { CompanyDashboard } from './company-dashboard/company-dashboard';
import { EventRegistration } from './event-registration/event-registration';
import { Counter } from './counter/counter';

@Component({
  selector: 'app-root',
  imports: [EmployeeComponent, Student, Product, CompanyDashboard, EventRegistration, Counter],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('angular-assignment');
}
