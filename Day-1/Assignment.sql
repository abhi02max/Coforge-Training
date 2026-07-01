create database School;
use School;

create table Students(
	StudentID int primary key,
    SName varchar(50),
    Age int,
    Gender varchar(10),
    City varchar(50)
    );

insert into Students values(101,'Rahul',20,'Male','Hyderabad');
insert into Students values(102,'Priya',19,'Female','Chennai');
insert into Students values(103,'Arjun',21,'Male','Bengaluru');
insert into Students values(104,'Sneha',20,'Female','Mumbai');
insert into Students values(105,'Kiran',22,'Male','Pune');

select * from Students;

select SName, City from Students;

select * from Students where Age > 20;

select * from Students where Gender = 'Female';

select * from Students where City = "Hyderabad";

select * from Students order by SName asc;

select * from Students order by Age desc;

SELECT * FROM students ORDER BY City ASC, SName ASC;

select * from Students where Age between 19 and 21;

select * from Students where SName like "R%";

select * from Students where City like "%i";

select * from Students where Age in (20,22);

update Students set City = "Delhi" where SName = "Rahul";

update Students set Age = Age + 1 where SName = "Arjun";

update Students set City = "Kolkata" where SName= "Sneha";

delete from Students where StudentID = 105;

delete from Students where City = "Chennai";


    