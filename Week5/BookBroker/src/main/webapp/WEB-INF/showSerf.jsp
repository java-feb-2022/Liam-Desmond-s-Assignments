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
	<div class="d-flex flex-row align-items-center bg-success text-white">
	<div class="d-flex flex-column w-auto">
	
		<h4 class="text-danger">Logged In:</h4>
		<h4>${userLog.name}</h4>
		<a class="btn btn-info" href="/logout">Logout</a>
	</div>

<c:choose>
<c:when test="${book.owner.id == userLog.id}">
<div class="d-flex justify-content-center flex-column align-items-center col-11 w-75">
<h2>You read ${book.title}</h2>
<a class="btn btn-dark mb-1" href="/dashboard">Home</a>


<%--Edit ------------- Delete--%>
<c:if test="${book.owner.id == userLog.id}">

	<div class="container d-flex flex-row justify-content-center">
		<a href="/edit/serf/${book.id}" class="btn btn-warning">Edit</a>
		<button onclick="location.href=`/delete/serf/${book.id}`" class="btn btn-danger">Delete</button>
	</div>
</c:if>

	<hr/>
</div>
</c:when>
<c:otherwise>
<div class="d-flex justify-content-center flex-column align-items-center col-11 w-75">
<h2>${book.title}</h2>
<a class="btn btn-dark mb-1" href="/dashboard">Home</a>


<%--Edit ------------- Delete--%>
<c:if test="${book.owner.id == userLog.id}">

	<div class="container d-flex flex-row justify-content-center">
		<a href="/edit/serf/${book.id}" class="btn btn-warning">Edit</a>
		<button onclick="location.href=`/delete/serf/${book.id}`" class="btn btn-danger">Delete</button>
	</div>
</c:if>

	<hr/>
</div>
</c:otherwise>
</c:choose>
</div>


<div class="container d-flex flex-row">
<div class="container d-flex flex-column justify-content-center align-items-center">
	<table class="table table-striped mt-2">
		<tbody>
			<tr>
				<th scope="row">Title:</th>
				<td>${book.title}</<td>
			</tr>
			<tr>
				<th scope="row">Author:</th>
				<td>${book.author}</<td>
			</tr>
			<tr>
				<th scope="row">Owner:</th>	
				<td><a href="/user/show/${book.owner.id}">${book.owner.name}</a></td>
			</tr>

		
		</tbody>
	</table>
	<c:if test="${book.owner.id == userLog.id}">
	<div class="container d-flex justify-content-center align-items-center flex-column">
	<h3>Your Thoughts</h3>
		<p>${book.thoughts}</p>
	</div>
	</c:if>

</div>
</div>


</body>
</html>