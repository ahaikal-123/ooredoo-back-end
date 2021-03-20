package com.oredoo.demo.exception;

public class CustomFranchiseException extends RuntimeException {

	public CustomFranchiseException() {

	}
	public CustomFranchiseException(String errorMessage, Throwable errorCause) {
		super(errorMessage, errorCause);
	}

	public CustomFranchiseException(String errorMessage) {
		super(errorMessage);
	}
}
