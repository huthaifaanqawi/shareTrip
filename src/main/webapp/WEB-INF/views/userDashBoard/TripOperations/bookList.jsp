<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Trip</title>
</head>
<body>
<body>

 	<section class="container" >
 		<div>

	<table id="cart_table" class="table table-hover">
	
		<tr>
					<th>---ID---</th>
					<th><spring:message code="trip.title"/></th>
					<th><spring:message code="trip.dateDeparture"/></th>
					<th><spring:message code="trip.dateArrival"/></th>
					<th><spring:message code="trip.type"/></th>
					<th><spring:message code="trip.origin"/></th>
					<th><spring:message code="trip.destination"/></th>
					<th><spring:message code="trip.driver"/></th>
					<th><spring:message code="trip.seats"/></th>
		</tr>
	
		<c:forEach  var="mytrip" items ="${bookings}" >
				<tr>
					<td>${mytrip.id}</td>
					<td>${mytrip.title}</td>
					<td><spring:eval expression="mytrip.departTime" /></td>
					<td><spring:eval expression="mytrip.returnTime" /></td>
					<td><c:choose>
							  <c:when test="${mytrip.type eq 'O'}">
							    One Way Trip
							  </c:when>
							  <c:otherwise>
							    Round Trip
							  </c:otherwise>
							</c:choose>
					</td>
					<td>${mytrip.origin.city}</td>
					<td>${mytrip.destination.city}</td>
					<td>${mytrip.member.firstName} ${mytrip.member.lastName}</td>
					<td>${mytrip.seats}</td>
				</tr>
		</c:forEach>
  
				
			</table>
			
</div>
</section>
</body>
</html>