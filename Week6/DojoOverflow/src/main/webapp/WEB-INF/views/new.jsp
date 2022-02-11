<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<a href="/">Dashboard</a>

<div class="container d-flex justify-content-center align-items-center flex-column">
	<a href="/create/tag">Add a Tag</a>
<%-- <h1>New Question</h1>
	<form:form action="/create/question" method="POST" modelAttribute="question">
		<form:label path="newQuestion">Question:</form:label>
		<form:errors path="newQuestion"></form:errors>
		<form:input path="newQuestion"></form:input>
		
		<button type="submit">Create</button>
	</form:form> --%>
	
	
	
	 	
	<div class="container d-flex justify-content-center align-items-center flex-column">
		<h1>What is your question</h1>
		<form:form action="/createQuestionAndTag" method="post" modelAttribute="question">
			 <div class="form-group">
		        <form:label path="newQuestion">Question</form:label>
		        <form:errors path="newQuestion"/>
		        <form:textarea class="form-control" path="newQuestion"></form:textarea>
		    </div>
		    <div class="form-group">
		        <label>Tags</label>

		        <input class="form-control" name="subject"/>
		    </div>
		    <button>Submit</button>
		</form:form>
</div>


	
</div>
</body>
</html>