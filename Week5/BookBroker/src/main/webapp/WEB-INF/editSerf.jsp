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
	<div class="d-flex justify-content-center flex-column w-auto">
	
		<h4 class="text-danger">Logged In:</h4>
		<h4>${userLog.name}</h4>
		<a class="btn btn-info mb-2" href="/logout">Logout</a>
	</div>

<div class="d-flex justify-content-center flex-column align-items-center col-11 w-75">
<h2>Edit</h2>
<a class="btn btn-dark" href="/dashboard">Home</a>



</div>
</div>

	
	<div class="container d-flex flex-column justify-content-center align-items-center">
	<form:form class='bookd p-3 bg-light' action="/edit/serf/proc/${book.id}" method="POST" modelAttribute="book">
	<form:input type="hidden" value="${book.owner.id}" path="owner" />
	<form:input type="hidden" value="${book.borrower.id}" path="borrower" />
	
			<div class="form-group">
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
			<br/>
			<form:errors path="title" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="author">Author:</form:label>
			<form:input path="author" />
			<br/>
			<form:errors path="author" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="thoughts">My Thoughts:</form:label>
			<form:textarea path="thoughts"></form:textarea>
			<br/>
			<form:errors path="thoughts" class="text-danger" />
		</div>
	
			<br/>
			<c:if test="${book.owner.id == userLog.id}">
			<div class="container d-flex flex-row justify-content-center">
				<button class="btn btn-warning">Update</button>
				<a href="/delete/serf/${book.id}" class="btn btn-danger">Delete</a>
			</div>
		</c:if>	
	</form:form>
	<hr class="border border-dark" style="width: 600px;"/>

			<a href="/serf/show/${book.id}" class="btn btn-primary">Back</a>
			

	</div>