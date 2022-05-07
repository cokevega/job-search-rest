package com.jgvega.rest.jobsearch.model.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.serializer.OfferSerializer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EnterpriseResponse implements Serializable {
	
	private static final long serialVersionUID = 889615063912852187L;
	
	private Long id;
	private String name;
	private String email;
	private Date createAt;
	private UserStatus status;
	private String description;
	@JsonSerialize(using = OfferSerializer.class)
	private List<Offer> offers;

}
