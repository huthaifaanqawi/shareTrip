package edu.mum.shareTrip.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import edu.mum.shareTrip.domain.dto.DomainErrors;
import edu.mum.shareTrip.exceptions.UserExistException;


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

}