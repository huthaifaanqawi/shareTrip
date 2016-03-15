<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<p>
	<form:errors path="*" cssStyle="color : red;" />
</p>
<div>

<form:form modelAttribute="trip" action= "addTrip" method="post">
    <fieldset>
        <legend><spring:message code="trip.legendform"/></legend>
        <p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
	    <p>
		    <label for="title"><spring:message code="trip.title"/></label>
		    <form:input path="title"/>
		</p>
		<p>
		    <label for="description"><spring:message code="trip.description"/></label>
		    <form:textarea path="description" rows="5" cols="30" />
		</p>
		<p>
		    <label for="departure"><spring:message code="trip.dateDeparture"/></label>
		    <form:input path="departTime" />
		</p>
		<p>
		    <label for="arrival"><spring:message code="trip.dateArrival"/></label>
		    <form:input path="returnTime" />
		</p>
		<p>
			<label for="type"><spring:message code="trip.type"/></label>
			<form:radiobutton path="type" value="O"/>One way 
			<form:radiobutton path="type" value="R"/>Round Trip 
		</p>
		<p>
		    <label for="origin"><spring:message code="trip.origin"/></label>
		    <form:select id="placeslist" path="origin.id" 
                	items="${placeslist}" itemLabel="city" itemValue="id"/>
		</p>
		<p>
		    <label for="destination"><spring:message code="trip.destination"/></label>
		    <form:select id="placeslist" path="destination.id" 
                	items="${placeslist}" itemLabel="city" itemValue="id"/>
		</p>
		<p>
			<label for="car"><spring:message code="trip.vehicle"/></label>
		    <form:select id="carlist" path="vehicle.id" 
                	items="${carlist}" itemLabel="plateNumber" itemValue="id"/>
		</p>

		<input id="reset" type="reset" value="Reset">
		<input id="submit" type="submit" value="Add Trip">
	</fieldset>
</form:form>



</div>