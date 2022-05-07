package com.jgvega.rest.jobsearch.model.response;

import com.jgvega.rest.jobsearch.entity.Enterprise;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class OfferResponse extends ListOfferResponse {

	private static final long serialVersionUID = 3339137841859186790L;
	
	private Enterprise enterprise;

}
