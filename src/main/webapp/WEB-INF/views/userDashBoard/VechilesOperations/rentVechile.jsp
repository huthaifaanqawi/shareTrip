 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Share Trip</title>
</head>
<body>
<body>
<section class="container" >
	
		<div class="row">
		<div class="col-md-5">
	<img src="<c:url value="/images/${vechile.id}.jpg"></c:url>" alt="image"  style = "width:100%"/>
 </div>
		
			<div class="col-md-5">
				<h3>${vechile.vechileName}</h3>
				<p>${vechile.description}</p>
				<p>
					<strong><spring:message code="addVehicle.form.vechileType"/></strong><span class="label label-warning">${vechile.type}</span>
				</p>
				<p>
					<strong><spring:message code="addVehicle.form.seatNumber"/></strong> ${vechile.seatNumber}
				</p>
		        <p>
					<strong><spring:message code="addVehicle.form.plateNumber"/></strong> ${vechile.plateNumber}
				</p>
				
				<p>
					<strong><spring:message code="addVechile.form.pricePerDay"/></strong> ${vechile.pricePerDay}
				</p>
					
				<p>
					<strong><spring:message code="addVehicle.form.addDate"/></strong> ${vechile.addDate}
				</p>
				<p>
				<form:form commandName="rental" method="post" >
				<input type="text" name="vechile.id" style="display: none;" value="${vechile.id}" />
					<div>
					<strong><spring:message code="addVehicle.form.fromDate"/></strong>
					<div>
						<form:input id="fromDate" path="fromDate" type="date"/>
						<form:errors path="fromDate"></form:errors>
						<label class="col-xs-2" id="pastDate" style="color:red;display: none;">please add date more than this date</label>
					</div>
				</div>
		<div>
		<strong><spring:message code="addVehicle.form.toDate"/></strong>
			<div>
						<form:input id="toDate" path="toDate" type="text"/>
					<form:errors path="toDate"></form:errors>
					
						</div>
				</div>
				<strong><spring:message code="addVehicle.form.unitPrice"/></strong>
			<div>
						<form:input id="unitPrice"  disabled="disabled" path="unitPrice" type="text"/>
			</div>
<input id="rent" disabled="disabled" type="submit" value="Rent Now"> 
</form:form>
<label class="col-xs-2" id="userisOwner" style="color:red;display: none;">you can't rent your car</label>
<a href="<spring:url value="/userRentLList" />" >
	<span class=""></span> View my Rent List
</a>

 <a href="<spring:url value="/borrowList" />" >
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
		</div>
<!--/div-->
	</section>
	
 	 <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$( document ).ready(function() {
		var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		var data = {"vechileid":$("#vechileid").val()};
		$.ajax({
			type:'GET',
		   url: '/shareTrip/rentUserCheckOwner/'+$("#vechileid").val(),
		   contentType: 'application/json',
		    success: function( resopnse) {
		    	if(resopnse.status==="hascar")
		    		{
		    		$("#userisOwner").css("display", "inline-block");
		    		$('#rent').prop('disabled', true)
		    		}
		    	else if(response.status==="nocar"){
		    		$("#userisOwner").css("display", "none");
					$('#rent').prop('disabled', false)
		    	}
				},
			error:function(errorObject){
				if(errorObject.responseJSON.errorType="UserNotOwnerOfVechile")
					{
					$("#userisOwner").css("display", "inline-block");
				$('#rent').prop('disabled', false);
					}
	}
	});

	});
	</script>
</body>
</html>