package com.oredoo.demo.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oredoo.demo.exception.CustomFranchiseException;
import com.oredoo.demo.exception.FranchiseApplicationCreationException;
import com.oredoo.demo.exception.FranchiseApplicationNotFoundException;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({FranchiseApplicationNotFoundException.class})
	public ResponseEntity<Object> handleNotFound(FranchiseApplicationNotFoundException notFoundException) {
		FranchiseApplicationNotFoundException franchiseApplicationNotFoundException =
			new FranchiseApplicationNotFoundException(notFoundException.getErrorMesg());
		return new ResponseEntity<>(
			franchiseApplicationNotFoundException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAll(Exception ex) {
		CustomFranchiseException customFranchiseException =
			new CustomFranchiseException(ex.getMessage(), ex);
		return new ResponseEntity<>(
			customFranchiseException, new HttpHeaders(), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler({FranchiseApplicationCreationException.class})
	public ResponseEntity<Object> handleNotCreated(FranchiseApplicationCreationException creationException) {
		FranchiseApplicationCreationException franchiseApplicationCreationException =
			new FranchiseApplicationCreationException(creationException.getErrorMesg());
		return new ResponseEntity<>(
			franchiseApplicationCreationException, HttpStatus.GATEWAY_TIMEOUT);
	}
}
