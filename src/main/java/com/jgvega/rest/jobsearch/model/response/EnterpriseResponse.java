package com.jgvega.rest.jobsearch.model.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.serializer.ListOfferSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class EnterpriseResponse extends EnterpriseResponseFromOffer implements Serializable {

	private static final long serialVersionUID = 889615063912852187L;

	@JsonSerialize(using = ListOfferSerializer.class)
	private List<Offer> offers;

}
