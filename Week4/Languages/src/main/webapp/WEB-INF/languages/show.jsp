<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${language.name}"/></title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="/languages">Dashboard</a>
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<h1><c:out value="${language.name}"/></h1>
		<p>Name: <c:out value="${language.name}"/></p>
		<p>Creator: <c:out value="${language.creator}"/></p>
		<p>Current Version: <c:out value="${currentVersion.numberOfPages}"/></p>
		<a href="/languages/${language.id}/edit">Edit Language</a>
		<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>