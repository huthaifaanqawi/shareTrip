<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<p>
	<form:errors path="*" cssStyle="color : red;" />
</p>
<div class="jumbotron">
<form:form modelAttribute="trip" action= "addTrip" method="post" class="form-horizontal">
    <fieldset>
        <legend><spring:message code="trip.legendform"/></legend>
        <p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
	    <div class="form-group">
		    <label class="col-xs-3 control-label" for="title"><spring:message code="trip.title"/></label>
		    <form:input class="col-xs-9 form-control" path="title"/>
		</div>
		<div class="form-group">
		    <label class="col-xs-3 control-label" for="description"><spring:message code="trip.description"/></label>
		    <form:textarea class="col-xs-9 form-control" path="description" rows="5" cols="30" />
		</div>
		<div class="form-group">
		    <label class="col-xs-3 control-label" for="departure"><spring:message code="trip.dateDeparture"/>(MM-dd-yyyy)</label>
		    <form:input class="col-xs-9 form-control" path="departTime" />
		</div>
		<div class="form-group">
		    <label class="col-xs-3 control-label" for="arrival"><spring:message code="trip.dateArrival"/>(MM-dd-yyyy)</label>
		    <form:input class="col-xs-9 form-control" path="returnTime" />
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label" for="type"><spring:message code="trip.type"/></label>
			<form:radiobutton path="type" value="O"/>One way 
			<form:radiobutton path="type" value="R"/>Round Trip 
		</div>
		<div class="form-group">
		    <label class="col-xs-3 control-label" for="origin"><spring:message code="trip.origin"/></label>
		    <form:select class="col-xs-9 form-control" id="placeslist" path="origin.id" 
                	items="${placeslist}" itemLabel="city" itemValue="id"/>
		</div>
		<div class="form-group">
		    <label class="col-xs-3 control-label" for="destination"><spring:message code="trip.destination"/></label>
		    <form:select class="col-xs-9 form-control" id="placeslist" path="destination.id" 
                	items="${placeslist}" itemLabel="city" itemValue="id"/>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label" for="car"><spring:message code="trip.vehicle"/></label>
		    <form:select class="col-xs-9 form-control" id="carlist" path="vehicle.id" 
                	items="${carlist}" itemLabel="plateNumber" itemValue="id"/>
		</div>

		<input id="reset" type="reset" value="Reset">
		<input id="submit" type="submit" value="Add Trip">
	</fieldset>
</form:form>
</div>