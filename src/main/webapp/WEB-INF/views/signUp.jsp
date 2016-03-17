<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
    function isUserExists(){
    	$.ajax({
    		url:'/shareTrip/getUser/'+$("#username").val(),
    		type:'GET',
    		contentType:'application/json',
    		success:function(){
    			$("#userExistsError").css("display", "none"); 
    			$('#register').prop('disabled', false);
    		},
    		error:function(errorObject){
    			if(errorObject.responseJSON.errorType="UserAlreadyExists"){
    				$("#userExistsError").css("display", "inline-block");
    				$('#register').prop('disabled', true);
    			}
    		}
    	});
    }
</script>
<title>Sign Up</title>
</head>
<body>
	<br />
	<div class="jumbotron">
		<form:form modelAttribute="member" action="register" method="post" class="form-horizontal">
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="firstName"><spring:message code="member.firstname" text="First Name:"/></label>
				<form:input class="col-xs-9 form-control" path="firstName" id="firstName" tabindex="1" />
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="lastName"><spring:message code="member.lastname" text="Last Name:"/></label>
				<form:input class="col-xs-9 form-control" path="lastName" id="lastName" tabindex="2" />
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="email"><spring:message code="member.email" text="Email:"/></label>
				<form:input class="col-xs-9 form-control" path="email" id="email" tabindex="3" />
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="gender"><spring:message code="member.gender" text="Gender:"/></label>
				<form:select class="col-xs-9 form-control" path="gender" tabindex="4">
				    <form:option value="">--Select--</form:option>
				    <form:option value="M">Male</form:option>
				    <form:option value="F">Female</form:option>
				</form:select>
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="birthday"><spring:message code="member.birthday" text="Birthday:"/></label>
				<form:input class="col-xs-9 form-control" path="birthday" id="birthday" tabindex="5"/>
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="phone"><spring:message code="member.phone" text="Phone:"/></label>
				<form:input class="col-xs-9 form-control" path="phone" id="phone" tabindex="5"/>
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="username"><spring:message code="member.username" text="Username:"/></label>
				<form:input class="col-xs-7 form-control" path="credentials.username" onblur="isUserExists()" id="username" tabindex="5"/>
				<label class="col-xs-2" id="userExistsError" style="color:red;display: none;">Username is used</label>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="password"><spring:message code="member.password" text="Password:"/></label>
				<form:input class="col-xs-9 form-control" type="password" path="credentials.password" id="password" tabindex="5"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="confirm_password"><spring:message code="member.confirmPassword" text="Confirm Password:"/></label>
				<form:input class="col-xs-9 form-control" type="password" path="credentials.verifyPassword" id="confirm_password" tabindex="5"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="authoroties"><spring:message code="member.role" text="Role:"/></label>
				<form:input class="col-xs-9 form-control" value="ROLE_USER" path="credentials.authority" id="authoroties" tabindex="10"/>
			</div>
			<div class="form-group">
			    <h2><spring:message code="member.address" text="Address:"/></h2>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="state"><spring:message code="member.address.state" text="State:"/></label>
				<form:input class="col-xs-9 form-control" type="text" path="address.state" id="state" tabindex="6"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="city"><spring:message code="member.address.city" text="City:"/></label>
				<form:input class="col-xs-9 form-control" type="text" path="address.city" id="city" tabindex="7"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="street"><spring:message code="member.address.street" text="Street:"/></label>
				<form:input class="col-xs-9 form-control" type="text" path="address.street" id="street" tabindex="8"/>
			</div>
			<div class="form-group">
			    <label class="col-xs-3 control-label" for="zipCode"><spring:message code="member.address.zipCode" text="State:"/></label>
				<form:input class="col-xs-9 form-control" type="text" path="address.zipCode" id="zipCode" tabindex="9"/>
			</div>
			<div class="form-group">
			    <div class="col-xs-offset-3 col-xs-9">
				    <input class="btn btn-default" type="submit" id="register" value="Register">
			    </div>
			</div>
		</form:form>
	</div>
</body>
</html>
