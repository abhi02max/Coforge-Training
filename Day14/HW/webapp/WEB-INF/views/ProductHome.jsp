<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management System</title>
<link rel="stylesheet" href="EMSStyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<h1>Product Management System</h1>
	</div>
	<br />
	<form action="product" method="post">
		<div class="content">
			<table>
				<tr>
					<td>Product ID</td>
					<td><input type="text" name="productId"></td>
				</tr>

				<tr>
					<td>Product Name</td>
					<td><input type="text" name="productName"></td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td><input type="text" name="productPrice"></td>
				</tr>

				<tr>
					<td>Product Quantity</td>
					<td><input type="text" name="productQuantity"></td>
				</tr>
			</table>
			<br /> <input type="submit" name="submit" value="Insert"
				class="btn btn-primary"> <input type="submit" name="submit"
				value="Update" class="btn btn-warning"> <input type="submit"
				name="submit" value="Delete" class="btn btn-danger"> <input
				type="submit" name="submit" value="Find" class="btn btn-info">
			<input type="submit" name="submit" value="FindAll"
				class="btn btn-info"> <br /> <br />
		</div>
	</form>

	<br>
	<div>
		<!-- Expression Languge -->
		<b>${result}</b>
	</div>

	<c:if test="${not empty productList}">
		<br>
		<div class="content">
			<table class="table table-bordered">
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
				</tr>
				<c:forEach var="p" items="${productList}">
					<tr>
						<td>${p.productId}</td>
						<td>${p.productName}</td>
						<td>${p.productPrice}</td>
						<td>${p.productQuantity}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>
