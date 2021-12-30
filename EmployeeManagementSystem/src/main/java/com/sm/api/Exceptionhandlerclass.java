package com.sm.api;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class Exceptionhandlerclass extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
	log.error("MethodArgumentNotValidException",ex);
	List<String> errors = new ArrayList<>();
	ex.getBindingResult().getFieldErrors()
			.forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
	ex.getBindingResult().getGlobalErrors()
			.forEach(error -> errors.add(error.getObjectName() + ": " + error.getDefaultMessage()));
	Collections.sort(errors);
		return handleMethodArgumentNotValid(ex, headers, status, request);
	}

@ExceptionHandler(ConstraintViolationException.class)
protected ResponseEntity<Set<String>> handleConstraintViolation(ConstraintViolationException e) {
	    Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

	Set<String> messages = new HashSet<>(constraintViolations.size());
	messages.addAll(constraintViolations.stream()
	        .map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
	                constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
	        .collect(Collectors.toList()));
	
	log.error( "Constraint violation exception thrown:",e);
	return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
	}


@ExceptionHandler(Exception.class)
protected ResponseEntity<Void> genericException(final Exception e) {

  log.error( "Unhandled Exception thrown:", e);
  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}

	
}
