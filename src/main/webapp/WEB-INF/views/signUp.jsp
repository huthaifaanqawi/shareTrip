<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Sign Up</title>
</head>
<body>
	<br />
	<div id="global">
		<form:form commandName="member" action="register" method="post">
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<p>
				<label>FirstName:</label>
				<form:input path="firstName" id="firstName" tabindex="1" />
				<form:errors path="firstName" cssStyle="color : red;" />
			</p>
			<p>
				<label>lastName:</label>
				<form:input path="lastName" id="lastName" tabindex="2" />
				<form:errors path="lastName" cssStyle="color : red;" />
			</p>
			<p>
				<label>Email:</label>
				<form:input path="email" id="email" tabindex="3" />
				<form:errors path="email" cssStyle="color : red;" />
			</p>
			<p>
				<label>Gender:</label>
				<form:input path="gender" id="gender" tabindex="4" />
				<form:errors path="gender" cssStyle="color : red;" />
			</p>
			<p>
				<label>Age:</label>
				<form:input path="age" id="age" />
				<form:errors path="age" cssStyle="color : red;" />
			</p>

			<p id="buttons">
				<input type="submit" id="register" value="Register">
			</p>
		</form:form>
	</div>
</body>
</html>
