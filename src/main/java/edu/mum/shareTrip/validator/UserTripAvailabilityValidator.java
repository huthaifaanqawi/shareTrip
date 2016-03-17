package edu.mum.shareTrip.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.domain.Trip;
import edu.mum.shareTrip.service.MemberService;

@Component
public class UserTripAvailabilityValidator implements ConstraintValidator<UserAvailability, Trip> {

	
	@Autowired
	MemberService memberService;
	
	@Override
	public void initialize(UserAvailability constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Trip value, ConstraintValidatorContext context) {
		
		if(memberService!=null){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName(); //get logged in username
			Member member = memberService.getMemberByUserName(name);
		
		
			if(memberService.getMemberAvailabilityTrip(member.getId(), value.getDepartTime(), value.getReturnTime(), value.getId()).size()>0
					|| memberService.getMemberAvailabilityBook(member.getId(), value.getDepartTime(), value.getReturnTime()).size()>0){
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate( "The user is alredy booked in this or another trip in the same lapse of time" ).addConstraintViolation();
				return false;
			}
		}
		return true;
	}

}
