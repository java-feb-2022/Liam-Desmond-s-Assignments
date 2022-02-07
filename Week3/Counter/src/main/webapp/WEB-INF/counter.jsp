<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Current Visit Count</title>
</head>
<body>
	<h1>You have visited <a href="/">Your server </a><c:out value="${countToShow}"/> Times</h1>
	<h3><a href="/">Test another visit?</a></h3>
	<h3><a href="/reset">Reset</a></h3>
</body>
</html>