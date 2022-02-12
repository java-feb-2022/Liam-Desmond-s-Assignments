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
		<h1 class="text-primary">Add a Course</h1>
		<form:form class='card p-3 bg-light' action="/course/create" method="POST" modelAttribute="course">
		
			<div class="form-group">
				<form:label path="name">Dojo Name:</form:label>
				<form:input path="name" />
				<br/>
				<form:errors path="name" class="text-danger" />
			</div>
	
			<button>Create</button>
	
		</form:form>
	</div>
</body>
</html>