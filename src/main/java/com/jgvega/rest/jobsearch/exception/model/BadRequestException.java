package com.jgvega.rest.jobsearch.exception.model;

import org.springframework.http.HttpStatus;

import com.jgvega.rest.jobsearch.util.Constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Exception thrown against malformed requests. Contains the common
 * <code>ErrorResponse</code> fields for this kind of error and its respective
 * instantiation.
 * 
 * @author cokev
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 4171965379972219563L;
	
	private String type;
	private String details;
	private String instance;
	
	/**
	 * Instantiation of an <code>ErrorResponse</code> containing the common fields
	 * (<code>status</code> and <code>title</code>) for any malformed request.
	 * 
	 * @param type     <code>ErrorResponse.type</code>
	 * @param details  type <code>ErrorResponse.details</code>
	 * @param instance type <code>ErrorResponse.instance</code>
	 * @return <code>ErrorResponse</code> generated instance
	 */
	public static ErrorResponse of(String type, String details, String instance) {
		return ErrorResponse.of(type, Constant.MESSAGE_BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), details, instance);
	}

}
