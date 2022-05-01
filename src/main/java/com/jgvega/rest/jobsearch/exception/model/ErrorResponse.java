package com.jgvega.rest.jobsearch.exception.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Error handling model following
 * <a href="https://datatracker.ietf.org/doc/html/rfc7807">RFC 7807</a>.
 * 
 * @author cokev
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1574791154923241383L;

	/**
	 * URI identifier that categorizes the error
	 */
	protected String type;
	/**
	 * Short message about the error
	 */
	protected String title;
	/**
	 * HTTP response code
	 */
	protected int status;
	/**
	 * Explanation of the error
	 */
	protected String detail;
	/**
	 * URI that identifies the specific occurrence of the error
	 */
	protected String instance;

	/**
	 * 
	 * @param type     URI identifier that categorizes the error
	 * @param title    Short message about the error
	 * @param status   HTTP response code
	 * @param details  Explanation of the error
	 * @param instance
	 * @return URI that identifies the specific occurrence of the error
	 */
	public static ErrorResponse of(String type, String title, int status, String detail, String instance) {
		return new ErrorResponse(type, title, status, detail, instance);
	}

}
