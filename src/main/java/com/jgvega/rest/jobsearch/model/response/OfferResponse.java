package com.jgvega.rest.jobsearch.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class OfferResponse extends OfferResponseFromEnterprise {

	private static final long serialVersionUID = 3339137841859186790L;
	
	private EnterpriseResponseFromOffer enterprise;

}
