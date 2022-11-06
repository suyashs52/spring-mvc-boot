package com.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleStudentNotFound(NotFoundException exc) {
		// create a student response
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
		// return
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleStudentException(Exception exc) {
		// create a student response
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
		// return
	}
}
