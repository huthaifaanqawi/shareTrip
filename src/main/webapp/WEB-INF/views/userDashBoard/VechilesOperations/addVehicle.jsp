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

    <h1>Add Vehicle</h1>
 <div class="jumbotron">
      <form:form commandName="vechile" method="post" enctype="multipart/form-data"  class="form-horizontal">
		  <p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
                  <div class="form-group">
					<label class="col-xs-3 control-label"  for="vechileName"><spring:message code="addVehicle.form.vechileName"/></label>
					<div>
                         	<form:input class="col-xs-9 form-control"    id="vechileName" path="vechileName" type="text"/>
							<form:errors path="vechileName"/>
					</div>
				</div>		
			<div class="form-group">
				<label class="col-xs-3 control-label"  for="type"><spring:message code="addVehicle.form.vechileType"/></label>
					<div >
						<form:select path="type" class="col-xs-9 form-control" >
						<form:option value="0">--Select Type</form:option>
						<form:option value="Car">Car</form:option>
						<form:option value="Bus">Bus</form:option>
						</form:select>
						<form:errors path="type"/>
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-xs-3 control-label"  for="seatNumber"><spring:message code="addVehicle.form.seatNumber"/></label>
					<div>
						<div>
							<form:input  class="col-xs-9 form-control"   id="seatNumber" path="seatNumber" type="text"/>
							<form:errors path="seatNumber"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label"  for="plateNumber"><spring:message code="addVehicle.form.plateNumber"/></label>
						<div>
							<form:input class="col-xs-9 form-control"  onblur="checkIfPlateFound()"  id="plateNumber" path="plateNumber" type="text"/>
                             	<label class="col-xs-2" id="platefound" style="color:red;display: none;">PlateNumber is found try another</label>						
							<form:errors path="plateNumber"/>
						</div>
				
				</div>
				<div class="form-group">
					<label  class="col-xs-3 control-label"  for="description"><spring:message code="addVechile.form.description"/></label>
					<div>
						<form:textarea class="col-xs-9 form-control"   id="description" path="description" rows="5" cols="30" />
						<form:errors path="description"/>
						</div>
					</div>
				<div class="form-group">
					<label class="col-xs-3 control-label"  for="pricePerDay"><spring:message code="addVechile.form.pricePerDay"/></label>
					<div>
						<form:input  class="col-xs-9 form-control"  id="pricePerDay" path="pricePerDay" type="text"/>
						<form:errors path="pricePerDay"/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-xs-3 control-label"  for="addDate"><spring:message code="addVehicle.form.addDate"/></label>
					<div>
						<form:input class="col-xs-9 form-control"  id="addDate" path="addDate" type="text"/>
						<form:errors path="addDate"/>
					</div>
				</div>
			<div class="form-group">
					<label class="col-xs-3 control-label"  for="status"><spring:message code="addVehicle.form.status"/></label>
					<div>
						<form:select path="status">
						<form:option value="available">available</form:option>
						</form:select>
						<form:errors path="status"/>
					</div>
				</div>
				
				<<div class="form-group">
					<label  class="col-xs-3 control-label"   for="vechileImage"><spring:message code="addVehicle.form.vehicleImage"/></label>
					<div>
						<form:input class="col-xs-9 form-control"  id="vechileImage" path="vechileImage"  type="file"/>
					</div>
				</div>
				<div>
				<input type="submit" value="Submit"  class="btn btn-default" />
				</div>
			</form:form>
			</div>
				 <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function checkIfPlateFound() {
		$.ajax({
			type:'GET',
		   url: '/shareTrip/checkPlate/'+$("#plateNumber").val(),
		   contentType: 'application/json',
		    success: function( resopnse) {
		    	if(resopnse.status==="hasplate")
		    		{
		    		$("#platefound").css("display", "inline-block");
		    		}
		    	else if(response.status==="noplate"){
		    		$("#platefound").css("display", "none");
		    	}
				},
			error:function(errorObject){
				if(errorObject.responseJSON.errorType="TheVechileNumberFound"){
    				$("#platefound").css("display", "none");
 
    			}
	}
	});
	};
	</script>
</body>
</html>