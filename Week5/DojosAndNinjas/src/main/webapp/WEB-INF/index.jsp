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

	<div class="container d-flex justify-content-center align-items-center flex-column">
	<a href="/dojo/new">Add a Dojo</a>
	<a href="/ninja/new">Add a Ninja</a>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th># of Ninjas</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="x" items="${dojos}">
				<tr>
					<td><a href="/dojo/${x.id}">${x.name}</a></td>
					<td>${x.ninjas.size()}</td>
					<td><a href="/dojo/editPage/${x.id}">Edit</a>|<a href="/dojo/delete/${x.id}">Delete</a></td>
				</tr>
			</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>