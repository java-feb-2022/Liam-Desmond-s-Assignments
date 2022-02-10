<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ page isErrorPage="true"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="bg-success text-white">
		<h2>Welcome ${userLog.name}!</h2>
	<a href="/logout" class="btn btn-info mb-2">Logout</a>
	</div>
	<div class="d-flex flex-column justify-content-center align-items-center">
		<h1>Book List</h1>
	</div>
	<div class="container">
	
			<button onclick="location.href=`/newSerfForm`" class="btn btn-success mb-2">Add a Book</button>

		<table class="table table-dark">
			<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Action</th>
			</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${allSerfs}" var="x">
			
			<tr>
				<td>${x.id}</td>

				<td><a href="/serf/show/${x.id}">${x.title}</a></td>
				<td>${x.author}</td>

				<td><a href="/user/show/${x.owner.id}">${x.owner.name}</a></td>
				<td><a href="/edit/serf/${x.id}">Edit</a>|<a href="/delete/serf/${x.id}">Delete</a></td>
			
			</tr>
			
			</c:forEach>
			</tbody>	
		</table>
	</div>
	
</body>
</html>