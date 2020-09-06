/**
 * 
 */
package com.tribehired.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tribehired.model.ErrorException;
import com.tribehired.model.ErrorInfo;

/**
 * @author User
 *
 */
@RestControllerAdvice
public class ErrorAdviceController {
	
	@ExceptionHandler(ErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleCustomException(ErrorException exception) {
        return new ErrorInfo(exception.getErrorMessage());
    }

}
