CREATE DATABASE EmployeeManagement;

USE EmployeeManagement;

CREATE TABLE Department (
    DeptID INT PRIMARY KEY,
    DeptName VARCHAR(50),
    Location VARCHAR(50)
);

INSERT INTO Department VALUES
(101,'HR','Hyderabad'),
(102,'Finance','Mumbai'),
(103,'IT','Bangalore'),
(104,'Sales','Chennai');

CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    EmpName VARCHAR(50),
    Gender VARCHAR(10),
    Age INT,
    Salary DECIMAL(10,2),
    Designation VARCHAR(50),
    DeptID INT,
    HireDate DATE,
    FOREIGN KEY (DeptID) REFERENCES Department(DeptID)
);

INSERT INTO Employee VALUES
(1,'Amit','Male',28,45000,'Software Engineer',103,'2022-05-10'),
(2,'Priya','Female',30,55000,'HR Manager',101,'2021-03-15'),
(3,'Rahul','Male',27,50000,'Accountant',102,'2023-01-20'),
(4,'Sneha','Female',25,42000,'Sales Executive',104,'2022-09-12'),
(5,'Kiran','Male',31,60000,'Team Lead',103,'2020-11-18');

CREATE TABLE Attendance (
    AttendanceID INT PRIMARY KEY,
    EmpID INT,
    AttendanceDate DATE,
    Status VARCHAR(10),
    FOREIGN KEY (EmpID) REFERENCES Employee(EmpID)
);

INSERT INTO Attendance VALUES
(1,1,'2026-07-01','Present'),
(2,2,'2026-07-01','Present'),
(3,3,'2026-07-01','Absent'),
(4,4,'2026-07-01','Present'),
(5,5,'2026-07-01','Present');

SELECT * FROM Employee;

SELECT EmpName, Salary FROM Employee;

SELECT * FROM Employee WHERE Salary > 50000;

SELECT * FROM Employee WHERE Age > 30;

SELECT * FROM Employee WHERE DeptID = 103;

SELECT *
FROM Employee
WHERE DeptID = (
SELECT DeptID
FROM Department
WHERE DeptName='IT'
);

SELECT *
FROM Employee
WHERE Gender='Female';

SELECT *
FROM Employee
WHERE HireDate > '2022-01-01';

SELECT *
FROM Employee
ORDER BY Salary DESC;

SELECT *
FROM Employee
ORDER BY EmpName ASC;

SELECT COUNT(*) AS TotalEmployees
FROM Employee;

SELECT MAX(Salary) AS HighestSalary
FROM Employee;

SELECT MIN(Salary) AS LowestSalary
FROM Employee;

SELECT AVG(Salary) AS AverageSalary
FROM Employee;

SELECT SUM(Salary) AS TotalSalary
FROM Employee;

SELECT DeptID,
COUNT(*) AS TotalEmployees
FROM Employee
GROUP BY DeptID;

SELECT DeptID,
AVG(Salary) AS AverageSalary
FROM Employee
GROUP BY DeptID;

SELECT DeptID,
MAX(Salary) AS HighestSalary
FROM Employee
GROUP BY DeptID;

SELECT DeptID,
COUNT(*) AS TotalEmployees
FROM Employee
GROUP BY DeptID
HAVING COUNT(*) > 1;

SELECT DeptID,
AVG(Salary) AS AvgSalary
FROM Employee
GROUP BY DeptID
HAVING AVG(Salary) > 50000;

SELECT e.EmpName,
d.DeptName
FROM Employee e
JOIN Department d
ON e.DeptID=d.DeptID;

SELECT e.EmpName,
d.DeptName,
d.Location
FROM Employee e
JOIN Department d
ON e.DeptID=d.DeptID;

SELECT
a.AttendanceID,
e.EmpName,
a.AttendanceDate,
a.Status
FROM Attendance a
JOIN Employee e
ON a.EmpID=e.EmpID;

UPDATE Employee
SET Salary = Salary * 1.10
WHERE DeptID=103;

UPDATE Employee
SET Designation='Senior Software Engineer'
WHERE EmpID=1;

UPDATE Employee
SET DeptID=102
WHERE EmpID=4;

DELETE FROM Employee
WHERE Salary < 40000;

DELETE FROM Attendance
WHERE AttendanceDate='2026-07-01';

CREATE VIEW EmployeeDetails AS
SELECT
e.EmpID,
e.EmpName,
d.DeptName,
e.Salary
FROM Employee e
JOIN Department d
ON e.DeptID=d.DeptID;

SELECT * FROM EmployeeDetails;

DELIMITER //

CREATE PROCEDURE GetEmployees()
BEGIN
    SELECT * FROM Employee;
END //

DELIMITER ;

CALL GetEmployees();