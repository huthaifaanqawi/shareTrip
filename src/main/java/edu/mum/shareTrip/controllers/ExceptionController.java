package edu.mum.shareTrip.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.shareTrip.domain.dto.DomainError;
import edu.mum.shareTrip.domain.dto.DomainErrors;
import edu.mum.shareTrip.exceptions.PlateNumberFoundException;
import edu.mum.shareTrip.exceptions.UserDriverException;
import edu.mum.shareTrip.exceptions.UserExistException;
import edu.mum.shareTrip.exceptions.UserNotAvailableException;
import edu.mum.shareTrip.exceptions.UserNotHaveVechileExpction;


@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(UserExistException.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ResponseBody
	public DomainErrors handleException(UserExistException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("UserAlreadyExists");
		return errors;
	}
	
	@ExceptionHandler(UserNotAvailableException.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ResponseBody
	public DomainErrors handleException(UserNotAvailableException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("UserNotAvailable");
		DomainError error = new DomainError("The user is already booked in another trip in this time.");
        errors.addError(error);
		return errors;
	}
	
	@ExceptionHandler(UserDriverException.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ResponseBody
	public DomainErrors handleException(UserDriverException exception) {
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("UserNotAvailable");
		DomainError error = new DomainError("The user is the same Driver of the trip.");
        errors.addError(error);
		return errors;
	}
		@ExceptionHandler(UserNotHaveVechileExpction.class)
		@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
		@ResponseBody
		public DomainErrors handleException(UserNotHaveVechileExpction exception) {
			DomainErrors errors = new DomainErrors();
			errors.setErrorType("UserNotOwnerOfVechile");
			return errors;
			
	}
		
		@ExceptionHandler(PlateNumberFoundException.class)
		@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
		@ResponseBody
		public DomainErrors handleException(PlateNumberFoundException exception) {
			DomainErrors errors = new DomainErrors();
			errors.setErrorType("TheVechileNumberFound");
			DomainError error = new DomainError("The Vechile  PlateNumber is Found");
	        errors.addError(error);
			return errors;
		}

}