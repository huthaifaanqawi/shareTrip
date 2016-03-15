<section class="container">
	<div class="row">
		<c:forEach items="${trips}" var="trip">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
						<div class="caption">
						<h3><spring:message code="trip.title"/> - ${trip.title}</h3>
						<p><spring:message code="trip.dateDeparture"/> - ${trip.departTime}</p>
						<p><spring:message code="trip.dateArrival"/> - ${trip.returnTime} </p>
						<p><spring:message code="trip.description"/> - ${trip.description}</p>
						<p><spring:message code="trip.type"/> - ${trip.type}</p>
						<p><spring:message code="trip.origin"/> - ${trip.origin} </p>
						<p><spring:message code="trip.destination"/> - ${trip.destination} </p>
						<p><spring:message code="trip.driver"/> - ${trip.member.firstname} ${trip.member.lastname}</p>
						<p>
							<a
								href=" <spring:url value="/book" /> "
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span><spring:message code="trip.book"/>
							</a>
						</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>