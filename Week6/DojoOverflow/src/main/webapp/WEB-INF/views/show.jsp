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
	<h3>Question:</h3>
	<p>${question.newQuestion}</p>
	
<div class="container d-flex justify-content-center align-items-center flex-column">
	<h1>Give an Answer</h1>
	
	<form:form action="/create/answerForQuestion" method="POST" modelAttribute="answer">
		<form:label path="newAnswer">Answer:</form:label>
		<form:input path="newAnswer"></form:input>
		<button>Add Answer</button>
		<br/>
		<form:errors path="newAnswer"></form:errors>
		<form:hidden path="question" value="${question.id}"/>
	</form:form>
</div>
</div>
<div class="container d-flex justify-content-center align-items-center flex-row flex-wrap">
	<p>Tags:</p>
	<ol>
		<c:forEach items="${question.tags}" var="x">
		<li><a href="/tags/show/${x.id}">${x.subject}</a></li>
		</c:forEach>
	</ol>
</div>

<div class="container d-flex justify-content-center align-items-center flex-row flex-wrap">

	<table>
<thead>
		<tr>
			<th>Answer</th>
		</tr>
</thead>
<tbody>
		<tr>
			<c:forEach items="${question.answers}" var="x">
				<td>${x.newAnswer}</td>
			</c:forEach>
		</tr>
</tbody>
	</table>

  


	
</div>
	<hr/>
	<div class="container d-flex justify-content-center align-items-center flex-column">
	<h4>Add a Tag</h4>
	<form action="/addSerfToMain/${question.id}" method="POST">

		<select name="tag_id">
			<c:forEach var="x" items="${tags}">
	    		<option value="${x.id}">${x.subject}</option>
			</c:forEach>
		</select>
		<br/>

		<button>Add Tag</button>
	</form>
	</div>
	
	
<%-- <div class="container d-flex justify-content-center align-items-center flex-column">

	<form action="/addSideToMain/${question.id}" method="POST">
		<p>Add an Answer</p>
		<select name="answer">
			<c:forEach var="x" items="${answers}">
	    		<option value="${x.id}">${x.newAnswer}</option>
			</c:forEach>
		</select>
		<br/>

		<button>Add Answer</button>
	</form>

	
	
	
	
	
<div class="container d-flex justify-content-center align-items-center flex-column">
	<h1>New Answer</h1>
	
	<form:form action="/create/answerForQuestion" method="POST" modelAttribute="answer">
		<form:label path="newAnswer">Answer:</form:label>
		<form:errors path="newAnswer"></form:errors>
		<form:input path="newAnswer"></form:input>
		<form:hidden path="question" value="${question.id}"/>
		<button>Add Answer</button>
	</form:form>
</div>--%>




</body>
</html>