package com.tribehired.model;

import java.io.Serializable;

public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = 3211916031030905256L;

	private String errorMessage;

	public ErrorInfo(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}