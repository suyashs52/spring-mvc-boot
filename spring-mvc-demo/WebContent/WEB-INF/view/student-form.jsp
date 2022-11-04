<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>

<body>
	<!-- modelAttribute must matched with controller getAttribute -->
	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName" />
		<br />
		<br />
		Last Name: <form:input path="lastName" />
		<br />
		<br />
		Country
		<form:select path="country">
			<%-- <form:option value="BR" label="Brazil"></form:option> --%>
			<!-- take the getter method of var -->
			<form:options items="${countryOptions}" />
		</form:select>
		
		<br/>
		<br/>
		Favorite Language:
		Java <form:radiobutton path="language" value="Java"/>
		C# <form:radiobutton path="language" value="C#"/>
		PHP <form:radiobutton path="language" value="PHP"/>
		Perl <form:radiobutton path="language" value="Perl"/>
		
		
		<br/><br/>
		Operating Systems:
		Linux <form:checkbox path="os" value="Linux"/>
		Mac <form:checkbox path="os" value="Mac OS"/>
		Windows <form:checkbox path="os" value="Windows"/>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>