package com.tribehired.model;

import java.io.Serializable;

public class ErrorException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 2869570730689087655L;
	private String errorMessage;

	public ErrorException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
