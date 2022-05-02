package com.jgvega.rest.jobsearch.model.response;

import java.util.Date;
import java.util.List;

import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EnterpriseResponse {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Date createAt;
	private UserStatus status;
	private String description;
	private List<Offer> offers;

}
