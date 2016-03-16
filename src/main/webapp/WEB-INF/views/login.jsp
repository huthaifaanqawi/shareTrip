<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
    <div class="jumbotron" class="form-horizontal">
		<form:form modelAttribute="user" action="login" method="post" class="form-horizontal">
		    <div class="form-group">
			    <label class="col-xs-3 control-label" for="username">Username:</label>
				<form:input class="col-xs-9 form-control" path="username" id="username" tabindex="1" />
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="password">Password:</label>
				<form:input type="password" class="col-xs-9 form-control" path="password" id="password" tabindex="2" />
			</div>
			<div class="form-group">
			    <div class="col-xs-offset-3 col-xs-9">
				    <input class="btn btn-primary" type="submit" id="signIn" value="Sign In">
			    </div>
			</div>
		</form:form>
    </div>
</body>
</html>