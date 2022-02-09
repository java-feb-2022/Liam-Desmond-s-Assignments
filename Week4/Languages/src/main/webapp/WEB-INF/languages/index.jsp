<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center flex-column p-5">
	<h1>All Languages</h1>

	<table class="table">
	    <thead>
	        <tr>
	            <th class="p-3">Name</th>
	            <th class="p-3">Creator</th>
	            <th class="p-3">Current Version</th>
	            <th class="p-3 w-6">Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="language">
	        <tr>
	            <td class="p-3"><a href="/languages/${language.id}">${language.name}</a></td>
	            <td class="p-3">${language.creator}</td>
	            <td class="p-3">${language.currentVersion}</td>

	            <td class="p-3"><a href="/languages/${language.id}/edit">Edit</a> | 
	            <form action="/languages/${language.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete">
				</form>
				</td>

	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
		<h1>Add a new Language</h1>
		<form:form action="/languages" method="post" modelAttribute="language">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="currentVersion">Current Version</form:label>
		        <form:errors path="currentVersion"/>
		        <form:input type="number" path="currentVersion"/>
		    </p>  
		    <input type="submit" value="Submit"/>
		</form:form> 
</div>
</body>
</html>