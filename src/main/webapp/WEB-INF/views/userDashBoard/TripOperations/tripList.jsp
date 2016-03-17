<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="js/bookTrip.js"/>"></script>
<style type="text/css">@import url("<c:url value="css/rest.css"/>");</style>
<section class="container">
	<div class="row">
		<c:forEach items="${trips}" var="mytrip" varStatus="status">
			<div id="div${mytrip.id}" class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
						<div class="caption">
						<h3><label id="labeltitle${mytrip.id}">${mytrip.title}</label></h3>
						<p><spring:message code="trip.dateDeparture"/> - <spring:eval expression="mytrip.departTime" /></p>
						<p><spring:message code="trip.dateArrival"/> - <spring:eval expression="mytrip.returnTime" /> </p>
						<p>- ${mytrip.description}</p>
						<p><spring:message code="trip.type"/> - 
							<c:choose>
							  <c:when test="${mytrip.type eq 'O'}">
							    One Way Trip
							  </c:when>
							  <c:otherwise>
							    Round Trip
							  </c:otherwise>
							</c:choose>
						</p>
						<p><spring:message code="trip.origin"/> - ${mytrip.origin.city} </p>
						<p><spring:message code="trip.destination"/> - ${mytrip.destination.city} </p>
						<p><spring:message code="trip.driver"/> - ${mytrip.member.firstName} ${mytrip.member.lastName}</p>
						<p><spring:message code="trip.seats"/> - <label id="labelseat${mytrip.id}">${mytrip.seats}</label></p>
						<p>
							<a class="btn btn-primary" onclick="makeAjaxCall(${mytrip.id});"> 
							<span class="glyphicon-info-sign glyphicon" /></span><spring:message code="trip.book"/>
							</a>
						</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>

<!-- Success - or Validation errors -->
 	<div id="result" style="display:none" >   	
 	    <p id="success" > 
 
 		</p> 
 		<p id="errors" > 
 
 		</p>
 	</div>
 	<div id="formInput" style="display:none" > </div>