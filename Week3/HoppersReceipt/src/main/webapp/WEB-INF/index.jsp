<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<div>
		<h1>Customer Name: ${name}</h1>
		<p>Item name: ${itemName}</p>
		<p>Price: $${price}</p>
		<p>Description: ${description}</p>
		<p>Vendor: ${vendor}</p>
	</div>
	
</body>
</html>