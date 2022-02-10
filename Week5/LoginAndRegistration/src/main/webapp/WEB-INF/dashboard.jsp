<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ page isErrorPage="true"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="warning">
	<a href="/logout" class="btn btn-info mb-2">Logout</a>
	</div>
	<div class="d-flex flex-column justify-content-center align-items-center">
		<h2>Welcome, ${userLog.userName}!</h2>
		<h1>This is your dashboard.  Nothing to see here.</h1>
	</div>
</body>
</html>