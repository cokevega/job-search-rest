package com.jgvega.rest.jobsearch.exception.model;

import org.springframework.http.HttpStatus;

import com.jgvega.rest.jobsearch.commons.exception.CommonException;
import com.jgvega.rest.jobsearch.util.Constant;

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
public class BadRequestException extends CommonException {

	private static final long serialVersionUID = 4171965379972219563L;

	public ErrorResponse response(String type, String detail, String instance) {
		this.type = type;
		this.detail = detail;
		this.instance = instance;
		this.status = HttpStatus.BAD_REQUEST.value();
		this.title = Constant.MESSAGE_BAD_REQUEST;
		return super.response(type, title, status, detail, instance);
	}

}
