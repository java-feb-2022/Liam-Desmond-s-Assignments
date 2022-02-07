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
<div class="container d-flex justify-content-center align-items-center">
	<h1>Gold <c:out value="${gold}"/></h1>
	<a href="/reset">Reset</a>
</div>
<div class="container d-flex justify-content-center align-items-center flex-row">
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<label>Farm</label>
		<form action="/process" method="POST">
			<input type=hidden name="hidden" value="farm"/>
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<label>House</label>
		<form action="/process" method="POST">
			<input type=hidden name="hidden" value="house"/>
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<label>Cave</label>
		<form action="/process" method="POST">
			<input type=hidden name="hidden" value="cave"/>
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="container d-flex justify-content-center align-items-center flex-column">
	<label>Casino</label>
		<form action="/process" method="POST">
			<input type=hidden name="hidden" value="casino"/>
			<button>Find Gold!</button>
		</form>
		

	</div>

</div>
<div class="container d-flex justify-content-center align-items-center flex-column">
		<c:forEach var="log" items="${log}">
    		<p><c:out value="${log}"/></p>
		</c:forEach>
</div>
</body>
</html>