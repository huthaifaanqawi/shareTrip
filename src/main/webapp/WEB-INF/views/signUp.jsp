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
		<form:form modelAttribute="member" action="register" method="post">
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<p>
				<label>FirstName:</label>
				<form:input path="firstName" id="firstName" tabindex="1" />
			</p>
			<p>
				<label>lastName:</label>
				<form:input path="lastName" id="lastName" tabindex="2" />
			</p>
			<p>
				<label>Email:</label>
				<form:input path="email" id="email" tabindex="3" />
			</p>
			<p>
				<label>Gender:</label>
				<form:select path="gender" tabindex="4">
				    <form:option value="">--Select--</form:option>
				    <form:option value="M">Male</form:option>
				    <form:option value="F">Female</form:option>
				</form:select>
			</p>
			<p>
				<label>Age:</label>
				<form:input path="age" id="age" tabindex="5"/>
			</p>
			<p>
				<label>Phone:</label>
				<form:input path="phone" id="phone" tabindex="5"/>
			</p>
			<p>
				<label>Username:</label>
				<form:input path="credentials.username" id="username" tabindex="5"/>
			</p>
			<p>
				<label>Password:</label>
				<form:input type="password" path="credentials.password" id="password" tabindex="5"/>
			</p>
			<p>
				<label>Confirm Password:</label>
				<form:input type="password" path="credentials.verifyPassword" id="confirm_password" tabindex="5"/>
			</p>
			<h1>Address</h1>
			<p>
				<label>State:</label>
				<form:input type="text" path="address.state" id="city" tabindex="6"/>
			</p>
			<p>
				<label>City:</label>
				<form:input type="text" path="address.city" id="city" tabindex="7"/>
			</p>
			<p>
				<label>Street:</label>
				<form:input type="text" path="address.street" id="city" tabindex="8"/>
			</p>
			<p>
				<label>Zip Code:</label>
				<form:input type="text" path="address.zipCode" id="city" tabindex="9"/>
			</p>
			<p id="buttons">
				<input type="submit" id="register" value="Register">
			</p>
		</form:form>
	</div>
</body>
</html>
