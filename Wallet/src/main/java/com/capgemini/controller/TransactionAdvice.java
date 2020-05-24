package com.capgemini.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dto.ErrorInfo;
import com.capgemini.exception.ApplicationException;

@RestControllerAdvice
public class TransactionAdvice {
	@ExceptionHandler(value = {ApplicationException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException1(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}
