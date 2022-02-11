<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center flex-column">

	
	<a href="/categories/new">Add a Category</a>
	<h1>New Product</h1>
	<form:form action="/create/product" method="POST" modelAttribute="product">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"></form:errors>
		<form:input path="name"></form:input>
		
		<form:label path="description">Description:</form:label>
		<form:errors path="description"></form:errors>
		<form:input path="description"></form:input>
		
		<form:label path="price">Price:</form:label>
		<form:errors path="price"></form:errors>
		<form:input path="price"></form:input>
		<button type="submit">Create</button>
	</form:form>
	 	
	

	
</div>
</body>
</html>