package edu.mum.shareTrip.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UserNameValidator.class)
@Documented
@interface UserName {
	String message() default "{edu.mum.shareTrip.validator.UserName.message}";
    Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}

public class UserNameValidator implements ConstraintValidator<UserName, String> {

	@Override
	public void initialize(UserName constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return false;
	}

}
