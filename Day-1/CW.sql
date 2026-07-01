create database testdata;
use testdata;

create table if not exists tbl_employee(
	eid int primary key,
    ename varchar(100),
    salary int);

START TRANSACTION;

insert into tbl_employee values(100,"Sai",658461654);

insert into tbl_employee values(101,"Sai",658461654);

insert into tbl_employee values(102,"Sai",658461654);

insert into tbl_employee values(103,"Sai",658461654);

insert into tbl_employee values(115,"Sai",658461654);

UPDATE tbl_employee
SET salary = 5000000
WHERE emp_id = 101;

insert into tbl_employee (eid,salary) values(110,264563);

DELETE FROM tbl_employee
WHERE eid IS NULL;

insert into tbl_employee (eid,salary) values (102,5000);

select * from tbl_employee where ename is null;

select *  from tbl_employee;

select * from tbl_employee where eid not in (101,104,103);

select * from tbl_employee where salary not between 1000000 and 2000000000000;

select ename from tbl_employee where ename like "S%_re_%h";

update tbl_employee set salary = 107363 where eid = 103;

set sql_safe_updates = 0;

savepoint point1;

select * from tbl_employee;

delete from tbl_employee where eid  = 115;

select * from tbl_employee;

rollback to savepoint point1;

select * from tbl_employee;

select ename as 'employee name' from tbl_employee;

alter table tbl_employee rename column employee_name to ename;

alter table tbl_employee add column location varchar(100);

alter table tbl_employee drop column location;

truncate table tbl_employee;

select eid,sysdate(), "Sai",100+200 from tbl_employee;

rename table employee to tbl_employee;