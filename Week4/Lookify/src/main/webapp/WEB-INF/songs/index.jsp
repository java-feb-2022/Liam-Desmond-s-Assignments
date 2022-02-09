<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify App</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center flex-column p-5">
	<h1>All Songs</h1>
	<a href="/top">Top Ten Songs</a>
	<p>-or-</p>
	<a href="/search">Search for a song mang!</a>

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
	        <c:forEach items="${songs}" var="song">
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
</body>
</html>