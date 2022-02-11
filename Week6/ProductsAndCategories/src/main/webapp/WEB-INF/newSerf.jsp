<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<a href="/">Dashboard</a>
	
<div class="container d-flex justify-content-center align-items-center flex-column">
	<a href="/products/new">Add a Product</a>
	<h1>New Category</h1>
	<form:form action="/create/category" method="POST" modelAttribute="category">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"></form:errors>
		<form:input path="name"></form:input>

		<button type="submit">Create</button>
	</form:form>

</div>

</body>
</html>