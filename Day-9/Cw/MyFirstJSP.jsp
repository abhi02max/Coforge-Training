<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MY First JSP</title>
</head>
<body>

	<%-- JSP Declaration tag (for declaration)--%>
	<%!//variables declared here are instance variables
	String name = "Harshika";
	int a = 10, b = 20;%>

	<%-- JSP Scriptlet tag (for business logic)--%>
	<%
	//variables decalred here are local variables
	out.println("<br>Welcome " + name); //out is implicit object in JSP
	if (a > b) {
		out.println("<br> a is Big.");
	} else {
		out.println("<br> b is Big.");
	}
	int sum = a + b;
	%>
	<br>
	<%-- JSP Expression tag (for business logic)--%>

	Sum =<%=sum%>

</body>
</html>