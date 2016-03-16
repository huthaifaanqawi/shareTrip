package edu.mum.shareTrip.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.mum.shareTrip.domain.Credentials;

public class CredentialsValidator implements ConstraintValidator<Credential, Credentials> {

	@Override
	public void initialize(Credential constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Credentials value, ConstraintValidatorContext context) {
		if(!value.getPassword().isEmpty() && !value.getVerifyPassword().isEmpty() && 
				!value.getPassword().equals(value.getVerifyPassword())){			
			return false;
		}
		return true;
	}

}