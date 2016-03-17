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
	<section>
 			<div id="prod" class="container"  >
   			     <div id="result" style="display:none" >
   		 </div>
			</div>
 	</section>	

 	<section class="container" >
 		<div>

			
			<table class="table table-hover">
				<tr>
			
					<th><spring:message code="addVehicle.form.vechileName"/></th>
					<th><spring:message code="addVehicle.form.fromdate"/></th>
					<th><spring:message code="addVehicle.form.todate"/></th>
					<th><spring:message code="addVechile.form.pricePerDay"/></th>
					<th><spring:message code="addVechile.form.TotalValue"/></th>
				</tr>
			</table>
	<table id="cart_table" class="table table-hover">
	
		<c:forEach  var="rental" items ="${rentals}" >
				<tr>
					
					<td>${rental.vechile.vechileName}</td>
					<td>${rental.fromDate}</td>
					<td>${rental.toDate}</td>
					<td>${rental.vehicle. pricePerDay}</td>
					<td>${rental. unitPrice}</td>
					<td>
				<a
									href=" <spring:url value="/rentVechile?id=${rental.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon glyphicon-ok" /></span> Details
								</a>	
					
				</td>
				</tr>
		</c:forEach>
  
				
			</table>
			
				<div id="vechileform" style="display:none" > </div>

</div> <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		</div>
	</section>

</body>
</html>