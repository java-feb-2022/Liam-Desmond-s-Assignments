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
	<h3>Name:</h3>
	<p>${product.name}</p>
	<h3>Description</h3>
	<p>${product.description}</p>
	<h3>Price:</h3>
	<p>${product.price}</p>
	<h3>Categories</h3>
	<ol>
		<c:forEach items="${product.categories}" var="x">
		<li><a href="/categories/show/${x.id}">${x.name}</a></li>
		</c:forEach>
	</ol>


<div class="container d-flex justify-content-center align-items-center flex-column">

	<form:form action="/addSerfToMain/${product.id}" method="POST" modelAttribute="categoryproduct">
		<input type="hidden" name="category_id"/>
		
		<form:input type="hidden" value="${product.id}" path="product"/>
		<form:select name="category_id" path="category">
			<c:forEach var="x" items="${categories}">
	    		<form:option value="${x.id}">${x.name}</form:option>
			</c:forEach>
		</form:select>
		<br/>

		<button>Add Product</button>
	</form:form>
</div>
</div>


</body>
</html>