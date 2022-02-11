<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center flex-column">
	<a href="/products/new">Add a Product</a>
	<a href="/categories/new">Add a Category</a>

	
<div class="container d-flex justify-content-center align-items-center flex-column">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${products}" var="x">
				<tr>
					<td><a href="/products/show/${x.id}">${x.name}</a></td>
					<td>${x.description}</td>
					<td>${x.price}</td>
			</c:forEach>
			</tbody>
		</table>
		
	</div>
	
</div>
	
</body>
</html>