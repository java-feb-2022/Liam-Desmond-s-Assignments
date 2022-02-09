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
<div class="container d-flex justify-content-center align-items-center flex-column">
		<a href="/">Dashboard</a>
<h2>Name: ${ninja.firstName}'s Info</h2>
<h2>First Name: ${ninja.firstName}</h2>
<h2>Last Name: ${ninja.lastName}</h2>
<h2>Age: ${ninja.age}</h2>
<h2>Dojo: ${ninja.dojo.name}</h2>
<br/>
<a href="/ninja/editPage/${ninja.id}">Edit This Ninja</a>
<a href="/ninja/delete/${ninja.id}">Delete This Ninja</a>
</div>
	
</body>
</html>