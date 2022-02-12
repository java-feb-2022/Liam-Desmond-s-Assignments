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
	<a href="/course/new">Add a Course</a>
	<a href="/student/new">Add a Student</a>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th># of Students</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			
 			<c:forEach var="x" items="${courses}">
				<tr>
					<td><a href="/course/${x.id}">${x.name}</a></td>
					<td>${x.students.size()}</td>
					<td><a href="/course/editPage/${x.id}">Edit</a>|<a href="/course/delete/${x.id}">Delete</a></td>
				</tr>
			</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>