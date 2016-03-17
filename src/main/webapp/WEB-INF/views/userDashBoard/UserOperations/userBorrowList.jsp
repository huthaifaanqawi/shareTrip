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
			
			<table class="table table-hover">
				<tr>
					<th>---ID---</th>
					<th><spring:message code="addVehicle.form.vechileName"/></th>
					<th><spring:message code="addVehicle.form.vechileType"/></th>
					<th><spring:message code="addVehicle.form.seatNumber"/></th>
					<th><spring:message code="addVechile.form.pricePerDay"/></th>
					<th><spring:message code="addVechile.form.description"/></th>
				</tr>
			</table>
	<table id="cart_table" class="table table-hover">
	
		<c:forEach  var="vehicle" items ="${vechiles}" >
				<tr>
					<td>${vehicle.id}</td>
					<td>${vehicle.vechileName}</td>
					<td>${vehicle.type}</td>
					<td>${vehicle.seatNumber}</td>
					<td>${vehicle. pricePerDay}</td>
					<td>${vehicle. description}</td>
					<td>
				</td>
				</tr>
		</c:forEach>
			</table>
	</section>
</body>
</html>