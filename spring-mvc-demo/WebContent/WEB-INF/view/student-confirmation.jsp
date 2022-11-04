<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Form</title>
</head>
<body>

	<hr />

	The Student is confirmed: ${student.firstName} ${student.lastName}
	<br /> Country : ${student.country}

	<br /> Favourite Language: ${student.language}

	<br /> Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.os}">
			<li>${temp}</li>
		</c:forEach>

	</ul>


</body>
</html>