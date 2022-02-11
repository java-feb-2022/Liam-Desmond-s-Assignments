<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>${tag.subject}</h1>

	<h3>Questions</h3>
	<ol>
		<c:forEach items="${tag.questions}" var="x">
		<li><a href="/questions/show/${x.id}">${x.newQuestion}</a></li>
		</c:forEach>
	</ol>


<div class="container d-flex justify-content-center align-items-center flex-column">

	<form action="/addMainToSerf/${tag.id}" method="POST">

		<select name="question_id">
			<c:forEach var="x" items="${questions}">
	    		<option value="${x.id}">${x.newQuestion}</option>
			</c:forEach>
		</select>
		<br/>

		<button>Add Question</button>
	</form>
</div>



</div>
</body>
</html>