<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Assignment</title>
</head>
<body>
	<%!int n = 10;
	int a = 2, b = 3;

	public int add(int a, int b) {
		return a + b;
	}%>

	<%
	out.println("Welcome to JSP <br>");
	out.println("Multiplication Table of 10 : <br>");
	for (int i = 1; i <= 10; i++) {
		out.println(n + " x " + i + " = " + (n * i) + "<br>");
	}
	%>
	<br>
	<b>Current Date and Time:</b>
	<%=new Date()%>

	<br>
	<br>
	<b>Declaration & Expression Demo:</b>
	<br> Sum of <%=a%> and <%=b%> = <%=add(a, b)%>


</body>
</html>