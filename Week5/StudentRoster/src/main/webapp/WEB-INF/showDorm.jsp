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
<h2>Name: ${dorm.name}</h2>
<h2>Students:</h2>
<form class='card p-3 bg-light' action="/student/add/${dorm.id}" method="POST">
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
			<c:forEach var="x" items="${dorm.students}">
		<tr>
			<td><a href="/student/${x.id}">${x.firstName} ${x.lastName}</a></td>
			<td>${x.age}</td>
			<td><a href="/student/remove/${x.id}">Remove This Student</a>|<a href="/student/delete/${x.id}">Delete This Student</a></td>
		</tr>
		    </c:forEach>
	</tbody>



	</table>
</div>
	
</body>
</html>