package com.jgvega.rest.jobsearch.exception.handler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jgvega.rest.jobsearch.exception.model.BadRequestException;
import com.jgvega.rest.jobsearch.exception.model.ErrorResponse;
import com.jgvega.rest.jobsearch.util.Constant;

/**
 * Controller for response in case of exception.
 * 
 * @author cokev
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// TODO: prepare instances and types for errors

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ ConstraintViolationException.class })
	@ResponseBody
	public ResponseEntity<ErrorResponse> validationFailed(ConstraintViolationException exc, WebRequest req) {
		String details = StringUtils.EMPTY;
		for (ConstraintViolation<?> violation : exc.getConstraintViolations()) {
			details += (violation.getPropertyPath() + ": " + violation.getMessage() + "; ");
		}
		details = details.substring(0, details.length() - 2);
		return ResponseEntity.badRequest().body(BadRequestException.of("type", details, "instance"));
	}

}
