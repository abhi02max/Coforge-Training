import { Component } from '@angular/core';

@Component({
  selector: 'app-company-dashboard',
  imports: [],
  templateUrl: './company-dashboard.html',
  styleUrl: './company-dashboard.css',
})
export class CompanyDashboard {
  companyName: string = 'Tech ABC';
  logoUrl: string = 'logo.jpeg';
  ceo: string = 'Vikram Malhotra';
  location: string = 'Bengaluru, India';
  employeesCount: number = 1250;
  revenue: string = '$15 Million';
}
