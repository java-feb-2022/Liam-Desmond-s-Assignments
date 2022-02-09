<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search for a Song</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="/songs">Dashboard</a>
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<form:form action="/search" method="post" modelAttribute="song">
		    <p>
		        <form:label path="title">Song Title</form:label>

		        <form:input path="title"/>
		    </p>
		<button type="submit">Search Foo!!!</button>
		</form:form>

	
	<div class="container d-flex justify-content-center align-items-center flex-column p-5">

	<table class="table">
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Artist</th>
	            <th>Rating</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="song" items="${songs}">
	        <tr>
	            <td><a href="/songs/${song.id}">${song.title}</a></td>
	            <td>${song.artist}</td>
	            <td>${song.rating}</td>
	            <td>	            
		            <form action="/songs/${song.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
				</td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<a href="/songs/new">Add a new Song Sucka!!</a>
</div>
	</div>
	

</body>
</html>