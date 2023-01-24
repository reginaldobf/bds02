package com.devsuperior.bds02.services.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> EntityNotFound(HttpServletRequest request, ResourceNotFoundException e) {
		
		StandardError se = new StandardError();
		se.setError("Entity not found");
		se.setMessage(e.getMessage());
		se.setPath(request.getRequestURI());
		se.setTimestamp(Instant.now());
		se.setStatus(HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dataBaseException(HttpServletRequest request, DatabaseException e) {
		
		StandardError se = new StandardError();
		se.setError("Database integrity violation");
		se.setMessage(e.getMessage());
		se.setPath(request.getRequestURI());
		se.setStatus(HttpStatus.BAD_REQUEST.value());
		se.setTimestamp(Instant.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
	}
}
