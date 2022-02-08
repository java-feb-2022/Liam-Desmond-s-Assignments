<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page isErrorPage="true"  %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container d-flex flex-column justify-content-center align-items-center">
		<a href="/new">Create an Expense</a>
		<table class="table table-striped mt-2">
			<thead>
				<tr>
					<th>Name</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="x" items="${all}">


				<tr>
					<td><a href="/show/${x.id}">${x.name}</a></td>
					<td>${x.vendor}</td>
					<td>${x.amount}</td>
					<td>${x.description}</td>
					<td><a href="delete/${x.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>


	
</body>
</html>