<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<h1>Here's Your Omikuji!</h1>
	</div>

	<div class="container d-flex justify-content-center border border-success flex-wrap bg-success w-25 h-50">
		<h4>In the next <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/> as your roomate, selling <c:out value="${hobby}"/>s for a living.  the next time you see a <c:out value="${thing}"/>, you will have good luck.  Also, <c:out value="${nice}"/>.</h4>
	</div>
	
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<a href="/">Go Back</a>
	</div>
</body>
</html>