<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center flex-column">
	<h1>Fruit Store</h1>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="x" items="${fruits}">
				<tr>
					<td>${x.name}</td>
					<td>${x.price}</td>
				</tr>
				</c:forEach>
				
			</tbody>
		
		</table>
	</div>
</body>
</html>