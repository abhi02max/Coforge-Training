select * from employee;
select * from department;
select * from attendance;

select EmpName , Salary from employee;

select * from employee where salary > 50000;

select * from employee where age > 30;

select * from employee where DeptID  = 
(select deptid from department where DeptName = "IT");

select * from employee where gender = "Female";

select * from employee where HireDate > "2022-01-01";

select * from employee order by salary desc;

select * from employee order by empname;

select count(*) from employee;

select max(salary) from employee;

select min(salary) from employee;

select avg(salary) from employee;

select sum(salary) from employee;

select deptid , count(*) from employee group by deptid;

select deptid, avg(salary) from employee group by deptid;

select deptid, max(salary) from employee group by deptid;

select e.empid, d.deptname from employee e natural join department d;

select e.empid, d.deptname, d.location from employee e 
natural join department d;

select e.empid, a.attendancedate, e.empname from employee e natural join attendance a;

update employee set salary = salary + salary/ 10 ;

update employee set designation = "Data Analyst" where empname = "Sneha";

update employee set deptid = 101 where empname = "Amit";

delete from employee where salary  < 40000;

delete from employee where AttendanceDate = "2026-07-01";

DELIMITER //
create procedure getEmployees()
begin
	select * from employee;
end //
DELIMITER ;

CALL getEmployees();

create view EmployeeDetails as 
select e.empname,d.deptname from employee e natural join department d;

