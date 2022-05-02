package com.jgvega.rest.jobsearch.model.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OfferLanguageResponse implements Serializable {

	private static final long serialVersionUID = -5910244376482841247L;

	private Long id;
	private String name;
	private String level;
	
}
