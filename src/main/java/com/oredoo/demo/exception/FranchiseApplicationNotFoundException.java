package com.oredoo.demo.exception;

public class FranchiseApplicationNotFoundException extends CustomFranchiseException {

	private final String errorMesg;
	private Throwable errorCause;

	public FranchiseApplicationNotFoundException(String errorText, Throwable errorCause) {
		super(errorText, errorCause);
		this.errorMesg = errorText;
		this.errorCause = errorCause;
	}

	public FranchiseApplicationNotFoundException(String errorText) {
		super(errorText);
		this.errorMesg = errorText;
	}

	public String getErrorMesg() {
		return errorMesg;
	}
}
