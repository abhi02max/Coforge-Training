<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<p><b><font color="green">Welcome <%=session.getAttribute("username") %></font></b></p>
<% 
	Cookie[] cookies = request.getCookies();
	out.println("<p><b><font color='green'>Welcome " + cookies[0].getValue() + "</font></b></p>"); 
%>
</body>
</html>