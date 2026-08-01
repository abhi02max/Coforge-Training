import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee-service';
import { Employee } from '../../models/employee';

@Component({
  selector: 'app-employee-component',
  standalone: false,
  templateUrl: './employee-component.html',
  styleUrl: './employee-component.css',
})
export class EmployeeComponent {

  employee : Employee = new Employee();
  result!: string;
  employees : Employee[] = [];

  constructor(private employeeService: EmployeeService){
    this.employee = new Employee();
  }

  saveEmployee(data : any){
    this.employee.eid = data.eid;
    this.employee.ename = data.ename;
    this.employee.esalary = data.esalary;
    this.employee.dno = data.dno;

    this.employeeService.saveEmployee(this.employee).subscribe({
      next: (res) => {
        console.log(res);
        this.result = res.toString();
      },
      error: (err) => {
        console.error(err);
        this.result = err.toString();
      }

    });
  }

  updateEmployee(data : any){
    this.employee.eid = data.eid;
    this.employee.ename = data.ename;
    this.employee.esalary = data.esalary;
    this.employee.dno = data.dno;

    this.employeeService.updateEmployee(this.employee).subscribe({
      next: (res:string) => {
        console.log(res);
        this.result = res.toString();
      },
      error: (err) => {
        console.error(err);
        this.result = err.toString();
      }

    });
  }

  deleteEmployee(data:any){
    const eid = data.eid;

    this.employeeService.deleteEmployee(eid).subscribe({

      next: (res:string) => {
        console.log(res);
        this.result = res;
      },

      error: (err) => {
        console.error(err);
        this.result = err.error;
      }
    });
  }

  findEmployee(data:any){
    const eid = data.eid;

    this.employeeService.findEmployee(eid).subscribe({

      next: (res:Employee) => {
        this.employee = res;
        this.result = "Employee Found Successfully";
      },

      error: (err) => {
        console.error(err);
        this.result = err.error;
      }
    });
  }

  findAllEmployees(){

    this.employeeService.findAllEmployees().subscribe({

      next: (res:Employee[]) => {
        console.log(res);
        this.employees = res;
        this.result = "Employees Found";
      },

      error: (err) => {
        console.error(err);
        this.result = err.error;
      }
    });
  }

  
}
