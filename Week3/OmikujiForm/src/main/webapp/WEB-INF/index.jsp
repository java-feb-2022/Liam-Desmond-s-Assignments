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
<h3>Login</h3>
    <form class="d-flex flex-column card p-3 bg-light" action='/omikuji/process' method='POST'>
	<label>Pick a number between 5 and 25:</label>
    	<input type="number" name='number'>
	<label>Enter a name:</label>
    	<input type="text" name='name'>
	<label>Enter a city name:</label>
    	<input type='text' name='city'>
	<label>Enter a hobby:</label>
    	<input type="text" name='hobby'>
	<label>Enter a living thing:</label>
    	<input type='text' name='thing'>
	<label>Say something nice to someone:</label>
    	<textarea name='nice'></textarea>
    	<input type='submit' value='Send and show a friend'>
    </form>
</div>
</body>
</html>