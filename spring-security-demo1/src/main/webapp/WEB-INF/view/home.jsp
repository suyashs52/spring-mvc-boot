<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>

	<p>Welcome to the luv2code company home page!</p>
	<p>
		User:
		<security:authentication property="principal.username" />
		<br /> <br /> Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	<security:authorize access="hasRole('MANAGER')">

		<!--  add a link that is accessible by manager-->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				Meeting</a> (Only for Manager People)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<!--  add a link system. this is for admin-->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System
				Meetings </a> (Only for Admin People)
		</p>
	</security:authorize>

	</hr>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>

</html>









