package edu.mum.shareTrip.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.mum.shareTrip.domain.Trip;

public class DestinationValidator implements ConstraintValidator<Destination, Trip> {

	@Override
	public void initialize(Destination constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Trip value, ConstraintValidatorContext context) {
		if(value.getOrigin().equals(value.getDestination())){
			
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate( "destination should be different than origin" ).addConstraintViolation();
			return false;
		}
		return true;
	}

}
