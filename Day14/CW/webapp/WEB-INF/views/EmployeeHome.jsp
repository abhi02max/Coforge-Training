<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link rel="stylesheet" href="EMSStyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<h1>Employee Management System</h1>
	</div>
	<br />
	<form action="employee" method="post">
		<div class="content">
			<table>
				<tr>
					<td>Employee id</td>
					<td><input type="text" name="eid"></td>
				</tr>

				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="ename"></td>
				</tr>
				<tr>
					<td>Employee Salary</td>
					<td><input type="text" name="esalary"></td>
				</tr>

				<tr>
					<td>Employee DeptNo</td>
					<td><input type="text" name="dno"></td>
				</tr>
			</table>
			<br /> <input type="submit" name="submit" value="Insert"
				class="btn btn-primary"> <input type="submit" name="submit"
				value="Update" class="btn btn-warning"> <input type="submit"
				name="submit" value="Delete" class="btn btn-danger"> <input
				type="submit" name="submit" value="Find" class="btn btn-info">
			<input type="submit" name="submit" value="FindAll"
				class="btn btn-info"> <br />
			<br />
		</div>
	</form>

	<br>
	<div>
		<!-- Expression Languge -->
		<b>${result}</b>
	</div>
</html>