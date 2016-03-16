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

			<div>
				 <a href="#" class="btn btn-success pull-right"> <span
					class="glyphicon-shopping-cart glyphicon"></span> Trip List
				</a>
			</div>
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
				<a
									href=" <spring:url value="/rentVechile?id=${vehicle.id}" /> "
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
	<script type="text/javascript">
	
	function getVechile(vechile_id){
		var contextRoot = "/" + window.location.pathname.split( '/' )[1];
		var dataToSend = {"id":vechile_id};
		var data = JSON.stringify(dataToSend);
		console.log(data);
		console.log(dataToSend);
		$.ajax({
				type:'GET',
    		   url: '/shareTrip/getVechile/',
    		   datatype:'json',
    		   contentType: 'application/json',
	 		    data: dataToSend ,
			    success: function( ) {
					},
				error:function(errorObject){
	    	//		if(errorObject.responseJSON.errorType="UserAlreadyExists"){
	    			
	    		//	}
		}
		});
		}

	
	
	</script>
</body>
</html>