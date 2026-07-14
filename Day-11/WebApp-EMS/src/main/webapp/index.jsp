<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link href = "EMSStyle.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src = "./AjaxScript.js"></script>
</head>
<body>

	<div class="header">
		<h1>Employee Management System</h1>
	</div>
	
	<br>
	<form action ="EmployeeController" method="post">
	<div class="content">
		<table>
			<tr>
				<td>Employee ID :</td>
				<td><input type="text" id = "eid" name = "eid" onblur = "getEmployeeDetails()"/></td>
			</tr>
			<tr>
				<td>Employee Name :</td>
				<td><input type="text" id="ename" name="ename"/></td>
			</tr>
			<tr>
				<td>Employee Salary :</td>
				<td><input type="text" id="esalary" name="esalary"/></td>
			</tr>
			<tr>
				<td>Department No :</td>
				<td><input type="text" id="dno" name="dno"/></td>
			</tr>
		</table>
		
		<br>
		<input type="submit" value="Insert" name = "emsButton" class = "btn btn-primary"/>&nbsp; &nbsp;
		<input type="submit" value="Delete" name = "emsButton" class = "btn btn-danger"/>&nbsp; &nbsp;
		<input type="submit" value="Update" name = "emsButton" class = "btn btn-warning"/>&nbsp; &nbsp;
		<input type="submit" value="Find" name = "emsButton" class = "btn btn-success"/>&nbsp; &nbsp;
		<input type="submit" value="FindAll" name = "emsButton" class = "btn btn-info"/>
		<br>				
	</div>
	</form>
	
	<div class = "alert alert-info">
		<!-- <center><b><%=request.getParameter("result") %></b></center> -->
    	<center><b>
    	<%= request.getAttribute("result") != null ? request.getAttribute("result") : "null" %>
    	</b></center>		
	</div>
	
</body>
</html>