<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center flex-column">
	<h1>All Books</h1>

	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Description</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${books}" var="book">
	        <tr>
	            <td>${book.title}</td>
	            <td>${book.description}</td>
	            <td>${book.language}</td>
	            <td>${book.numberOfPages}</td>
	            <td><a href="/books/${book.id}">Show/Delete</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="/books/new">New Book</a>
</div>
</body>
</html>