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
		<a href="/">Dashboard</a>
<h2>Name: ${course.name}</h2>
<h2>Students:</h2>
<form class='card p-3 bg-light' action="/student/add/${course.id}" method="POST">
<input type="hidden" value="student" name="student"/>
		<div class="form-group">
		
			<select name="id">
			
				<c:forEach var="x" items="${students}">
					<option value="${x.id}">${x.firstName} ${x.lastName}</option>
				</c:forEach>
				
			</select>
		</div>
		<input type="submit" value="Add Student" class="text-success"/>
</form>
	<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Action</th>
		</tr>
	</thead>
	
	<tbody>
			<c:forEach var="x" items="${course.students}">
		<tr>
			<td><a href="/student/${x.id}">${x.firstName} ${x.lastName}</a></td>
			<td>${x.age}</td>
			<td><form class='card p-3 bg-light' action="/student/remove/${x.id}" method="POST">
				<input type="hidden" value="${course.id}" name="course"/>

				<input type="submit" value="Remove This Student" class="text-warning"/>
				</form>
				<form class='card p-3 bg-light' action="/student/delete/${x.id}" method="POST">
				<input type="hidden" value="${course.id}" name="course"/>

				<input type="submit" value="Delete This Student" class="text-danger"/>
				</form>
		</tr>
		    </c:forEach>
	</tbody>



	</table>
</div>
	
</body>
</html>