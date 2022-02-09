<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page isErrorPage="true"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
		<div class="container d-flex flex-column justify-content-center align-items-center mt-2">
				<a href="/">Dashboard</a>
		<h1 class="text-primary">Edit expense</h1>
		
		
	<form:form class='card p-3 bg-light' action="/edit/${expense.id}" method="PUT" modelAttribute="expense">

		<div class="form-group">
			<form:label path="name">Expense Name:</form:label>
			<form:input path="name" />
			<br/>
			<form:errors path="name" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="vendor">Vendor Name:</form:label>
			<form:input path="vendor" />
			<br/>
			<form:errors path="vendor" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="amount">Amount:</form:label>
			<form:input path="amount" />
			<br/>
			<form:errors path="amount" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="description">Description:</form:label>
			<form:textarea path="description" ></form:textarea>
			<br/>
			<form:errors path="description" class="text-danger" />
		</div>

		<button>Update</button>

	</form:form>

</div>
</body>
</html>