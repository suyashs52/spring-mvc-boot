<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mycss.css">
<script src="${pageContext.request.contextPath}/resources/js/simple.js"></script>

<title>Hello world</title>
</head>
<body>

	Hello world from demo page

	<br />
	<br /> Student name : ${param.studentName}
	<br />
	<br /> The Message : ${message}
	
	<img src="${pageContext.request.contextPath}/resources/images/myfimg.jpeg" />
</body>
</html>