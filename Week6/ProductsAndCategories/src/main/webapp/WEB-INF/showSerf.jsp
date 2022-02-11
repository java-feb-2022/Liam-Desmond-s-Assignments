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
	<h1>${category.name}</h1>

	<h3>Products</h3>
	<ol>
		<c:forEach items="${category.products}" var="x">
		<li><a href="/products/show/${x.id}">${x.name}</a></li>
		</c:forEach>
	</ol>


<div class="container d-flex justify-content-center align-items-center flex-column">

	<form:form action="/addMainToSerf/${category.id}" method="POST" modelAttribute="categoryproduct">
		<input type="hidden" name="product_id"/>
		
		<form:input type="hidden" value="${category.id}" path="category"/>
		<form:select name="product_id" path="product">
			<c:forEach var="x" items="${products}">
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