<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center flex-column">
	<h1>New Answer</h1>
	
	<form:form action="/create/answer" method="POST" modelAttribute="answer">
		<form:label path="newAnswer">Answer:</form:label>
		<form:errors path="newAnswer"></form:errors>
		<form:input path="newAnswer"></form:input>

	

		<form:label path="question">Question:</form:label>
	 	<form:select path="question">
 			<c:forEach items="${questions}" var="x">
 				<form:option value="${x.id}">${x.newQuestion}</form:option>
 			</c:forEach>
	 	</form:select>
	 	
		<button type="submit">Create</button>
	</form:form>
	

	
</div>
</body>
</html>