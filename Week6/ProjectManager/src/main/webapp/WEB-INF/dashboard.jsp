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
		<h2>Welcome ${userLog.firstName}!</h2>
	<a href="/logout" class="btn btn-info mb-2">Logout</a>
	</div>
	<div class="d-flex flex-column justify-content-center align-items-center">
		<h1>List</h1>
	</div>
	<div class="container">
	
			<button onclick="location.href=`/newSerfForm`" class="btn btn-success mb-2">Add Project</button>



		<table class="table table-dark">
			<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Due Date</th>
				<th>Tasks</th>
				<th>Action</th>
			</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${allSerfs}" var="x">
			<c:choose>
			<c:when test="${x.owners.contains(userLog)}">
			<tr></tr>
			</c:when>
			<c:otherwise>


			<tr>
				<td>${x.id}</td>

				<td><a href="/serf/show/${x.id}">${x.title}</a></td>
				<td><fmt:formatDate value="${x.date}" pattern="MMM dd, yyyy"/></td>

				<td>${x.tasks.size()}</td>


				<td><a href="/borrow/${x.id}">Join</a></td>

			</tr>
			

			</c:otherwise>
			</c:choose>
			</c:forEach>
			</tbody>	
		</table>
	<div class="d-flex flex-column justify-content-center align-items-center">
		<h1>My Projects</h1>
	</div>

			<table class="table table-dark">
			<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Due Date</th>

				<th>Tasks</th>
				<th>Action</th>
			</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${allSerfs}" var="x">
 			<c:if test="${x.owners.contains(userLog)}">
			<tr>
				<td>${x.id}</td>
				<td><a href="/serf/show/${x.id}">${x.title}</a></td>
				<td><fmt:formatDate value="${x.date}" pattern="MMM dd, yyyy"/></td>
				


 				<td>${x.tasks.size()}</td>

				<td><a href="/unborrow/${x.id}">Leave</a></td>


		
			</tr>
 			</c:if>
			</c:forEach>
			</tbody>	
		</table>
	</div>


</body>
</html>
