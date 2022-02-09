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
<h2>Name: ${dojo.name}</h2>
<h2>Ninjas:</h2>
	<ul>
	<c:forEach var="x" items="${dojo.ninjas}">
		<li><a href="/ninja/${x.id}">${x.firstName} ${x.lastName}</a> - Age: ${x.age}</li>
    </c:forEach>
	</ul>
</div>
	
</body>
</html>