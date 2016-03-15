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

    <h1>Add Vehicle Hello</h1>
 
      <form:form commandName="vechile" action ="addVehicle" method="post">
		
                    <div>
					<label for="vechileName"><spring:message code="addVehicle.form.vechileName"/></label>
					<div>
                         	<form:input id="vechileName" path="vechileName" type="text"/>
							<form:errors path="vechileName"/>
					</div>
				</div>		
			<div>
				<label for="type"><spring:message code="addVehicle.form.vechileType"/></label>
					<div>
						<form:select path="type">
						<form:option value="0">--Select Type</form:option>
						<form:option value="1">Car</form:option>
						<form:option value="2">Bicycle</form:option>
						<form:option value="3">Truck</form:option>
						</form:select>
						<form:errors path="type"/>
					</div>
				</div>
				<div>
					<label for="seatNumber"><spring:message code="addVehicle.form.seatNumber"/></label>
					<div>
						<div>
							<form:input id="seatNumber" path="seatNumber" type="text"/>
							<form:errors path="seatNumber"/>
						</div>
					</div>
				</div>
				<div>
					<label for="plateNumber"><spring:message code="addVehicle.form.plateNumber"/></label>
					<div>
						<div>
							<form:input id="plateNumber" path="seatNumber" type="text"/>
							<form:errors path="plateNumber"/>
						</div>
					</div>
				</div>
				<div>
					<label for="description"><spring:message code="addVechile.form.description"/></label>
					<div>
						<form:textarea id="description" path="description" rows = "4"/>
						<form:errors path="description"/>
					</div>
				</div>
				<div>
					<label for="pricePerDay"><spring:message code="addVechile.form.pricePerDay"/></label>
					<div>
						<form:input id="pricePerDay" path="pricePerDay" type="text"/>
						<form:errors path="pricePerDay"/>
					</div>
				</div>

				<div>
					<label for="addDate"><spring:message code="addVehicle.form.addDate"/></label>
					<div>
						<form:input id="addDate" path="addDate" type="text"/>
						<form:errors path="addDate"/>
					</div>
				</div>
			<div>
					<label for="status"><spring:message code="addVehicle.form.status"/></label>
					<div>
						<form:select path="status">
						<form:option value="1">available</form:option>
						</form:select>
						<form:errors path="status"/>
					</div>
				</div>
				
				<div>
					<label for="vechileImage"><spring:message code="addVehicle.form.vehicleImage"/></label>
					<div>
						<form:input id="vechileImage" path="vechileImage" type="file"/>
						<form:errors path="vechileImage"/>
					</div>
				</div>
			</form:form>
</body>
</html>