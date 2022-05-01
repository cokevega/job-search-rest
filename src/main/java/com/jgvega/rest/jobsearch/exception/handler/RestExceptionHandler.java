package com.jgvega.rest.jobsearch.exception.handler;

import javax.persistence.EntityNotFoundException;
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
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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

	// TODO: create instances and types for errors

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ ConstraintViolationException.class })
	@ResponseBody
	public ResponseEntity<ErrorResponse> validationFailed(ConstraintViolationException exc, WebRequest req) {
		String details = StringUtils.EMPTY;
		for (ConstraintViolation<?> violation : exc.getConstraintViolations()) {
			details += (violation.getPropertyPath() + ": " + violation.getMessage() + "; ");
		}
		details = details.substring(0, details.length() - 2);
		return ResponseEntity.badRequest().body((new BadRequestException()).response(
				Constant.TYPE_CONTRAINT_VIOLATION_EXCEPTION, details, Constant.INSTANCE_CONTRAINT_VIOLATION_EXCEPTION));
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ EntityNotFoundException.class })
	@ResponseBody
	public ResponseEntity<ErrorResponse> entityNotFound(EntityNotFoundException exc, WebRequest req) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorResponse.of(Constant.TYPE_ENTITY_NOT_FOUND_EXCEPTION,
						Constant.TITLE_ENTITY_NOT_FOUND_EXCEPTION, HttpStatus.NOT_FOUND.value(),
						Constant.DETAIL_ENTITY_NOT_FOUND_EXCEPTION, Constant.INSTANCE_ENTITY_NOT_FOUND_EXCEPTION));
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	@ResponseBody
	public ResponseEntity<ErrorResponse> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException exc,
			WebRequest req) {
		StringBuilder detail = new StringBuilder(StringUtils.EMPTY);
		detail.append("Parameter ").append(exc.getParameter().getParameterName()).append(" requires type ")
				.append(exc.getRequiredType()).append(", but received the following value: " + exc.getValue());
		return ResponseEntity.badRequest()
				.body((new BadRequestException()).response(Constant.TYPE_METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION,
						detail.toString(), Constant.INSTANCE_METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION));
	}

}
