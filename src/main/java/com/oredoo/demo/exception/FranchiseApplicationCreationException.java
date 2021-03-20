package com.oredoo.demo.exception;

public class FranchiseApplicationCreationException extends CustomFranchiseException {

	private final String errorMesg;
	private Throwable errorCause;

	public FranchiseApplicationCreationException(String errorText, Throwable errorCause) {
		super(errorText, errorCause);
		this.errorMesg = errorText;
		this.errorCause = errorCause;
	}

	public FranchiseApplicationCreationException(String errorText) {
		super(errorText);
		this.errorMesg = errorText;
	}

	public String getErrorMesg() {
		return errorMesg;
	}
}
