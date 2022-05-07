package com.jgvega.rest.jobsearch.model.response;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class EnterpriseResponseFromOffer implements Serializable {

	private static final long serialVersionUID = 889615063912852187L;

	protected Long id;
	protected String name;
	protected String email;
	protected Date createAt;
	protected String status;
	protected String description;

}
