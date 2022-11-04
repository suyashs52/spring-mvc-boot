<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	${pageContext.request.contextPath}
	<h2>Company Home Page!!</h2>

	<hr />
	<p>Welcome to home page</p>
	<form:form action="/spring-security-demo/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>


	<p>use File>New>Maven Project>serch webapp> select org.maven fix
		servlet issue by adding dependency of javax.servlet, maven first
		search on jar on local repository at c\users\homedir\.m2\repository if
		not found then it ll search on internet on central repo
		repo.maven.apache.org/maven2 C:\Users\suysingh\.m2\repository Check
		the vulnerablity present in 5.2.11 at
		https://mvnrepository.com/artifact/org.hibernate/hibernate-core/5.2.11.Final

	</p>
	
	<p>_csrf token by default added by form tag of spring , check view source of form tag</p>

</body>
</html>