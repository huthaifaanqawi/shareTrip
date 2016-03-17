package edu.mum.shareTrip.validator;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.mum.shareTrip.domain.Trip;

public class DateTripValidator implements ConstraintValidator<DateTrip, Trip> {

	@Override
	public void initialize(DateTrip constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Trip value, ConstraintValidatorContext context) {
		try{
			Calendar cal1 = Calendar.getInstance();
	    	Calendar cal2 = Calendar.getInstance();
	    	cal1.setTime(value.getDepartTime());
	    	cal2.setTime(value.getReturnTime());
			
			if(cal1.after(cal2)){
				
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate( "Arrival date should be after or at least at the same day" ).addConstraintViolation();
				return false;
			}
			
			return true;
		}catch (Exception e){
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate( "Invalid Date" ).addConstraintViolation();
			return false;
		}
	}

}
