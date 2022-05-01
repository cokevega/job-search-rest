package com.jgvega.rest.jobsearch.commons.exception;

import java.io.Serializable;

import com.jgvega.rest.jobsearch.exception.model.ErrorResponse;

public class CommonException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 990336359222629441L;

	protected String type;
	protected String title;
	protected int status;
	protected String detail;
	protected String instance;

	/**
	 * Instantiation of an <code>ErrorResponse</code> containing the common fields
	 * (<code>status</code> and <code>title</code>) for any malformed request.
	 * 
	 * @param type     <code>ErrorResponse.type</code>
	 * @param details  type <code>ErrorResponse.details</code>
	 * @param instance type <code>ErrorResponse.instance</code>
	 * @return <code>ErrorResponse</code> generated instance
	 */
	protected ErrorResponse response(String type, String title, int status, String detail, String instance) {
		return ErrorResponse.of(type, title, status, detail, instance);
	}

}
