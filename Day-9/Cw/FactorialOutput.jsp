<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file = "FactorialInput.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Factorial Output</title>
</head>
<body>

<b>

<!--  
Factorial of <%= request.getParameter("n") %> 
is : <%= request.getParameter("fact") %>
-->

Factorial of <%= request.getAttribute("n") %> 
is : <%= request.getAttribute("fact") %>

</b>

</body>
</html>