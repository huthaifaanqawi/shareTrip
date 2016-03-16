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
				<form id="data">
					<div>
					<strong><spring:message code="addVehicle.form.fromDate"/></strong>
					<div>
						<input id="fromDate" name="fromDate" type="text"/>
					</div>
				</div>
		<div>
		<strong><spring:message code="addVehicle.form.toDate"/></strong>
			<div>
						<input id="toDate" name="toDate" type="text"/>
						</div>
				</div>
			</form>
				<h4></h4>
			
 					<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${vechile.id}')"> 
<span class="glyphicon-shopping-cart glyphicon"></span> Rent Now </a>
<a href="<spring:url value="/rentVechile" />" class="btn btn-default">
	<span class="glyphicon-hand-right glyphicon"></span> View myList
</a>

 <a href="<spring:url value="/borrowList" />" class="btn btn-default">
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