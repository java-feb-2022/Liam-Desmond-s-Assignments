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
	<div class="container d-flex flex-column justify-content-center align-items-center mt-2">
				<a href="/">Dashboard</a>
		<h1 class="text-primary">Add a Student</h1>
	<form:form class='card p-3 bg-light' action="/student/create" method="POST" modelAttribute="student">
	
		<div class="form-group">
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName" />
			<br/>
			<form:errors path="firstName" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName" />
			<br/>
			<form:errors path="lastName" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="age">Age:</form:label>
			<form:input path="age" />
			<br/>
			<form:errors path="age" class="text-danger" />
		</div>

		<button>Add Student</button>

	</form:form>
	</div>
</body>
</html>