package edu.mum.shareTrip.validator;

import java.lang.annotation.ElementType;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = UserTripAvailabilityValidator.class)
@Documented
public @interface UserAvailability {
	
	String message() default "{user.trip.message}";
    Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};

}
