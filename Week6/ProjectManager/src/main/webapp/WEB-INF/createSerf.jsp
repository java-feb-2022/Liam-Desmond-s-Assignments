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
	<div class="d-flex flex-column col-1 w-auto">
	
		<h4 class="text-danger">Logged In:</h4>
		<h4>${userLog.firstName} ${userLog.lastName}</h4>
		<a class="btn btn-info mb-1" href="/logout">Logout</a>
	</div>

<div class="d-flex  flex-column align-items-center col-11 w-75">
<h2>Add Something</h2>
<a class="btn btn-dark mb-1" href="/dashboard">Home</a>

</div>
</div>
	

	<div class="container d-flex flex-column justify-content-center align-items-center mt-2">

	<form:form class='card p-3 bg-light' action="/create/serf" method="POST" modelAttribute="projectForm">
	
		<div class="form-group">
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
			<br/>
			<form:errors path="title" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="date">Due Date:</form:label>
			<form:input type="date" path="date" />
			<br/>
			<form:errors path="date" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="description">Description:</form:label>
			<form:input path="description" />
			<br/>
			<form:errors path="description" class="text-danger" />
		</div>
		<button>Create</button>

	</form:form>

</div>
</body>
</html>