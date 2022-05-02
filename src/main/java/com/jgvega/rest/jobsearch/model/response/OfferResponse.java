package com.jgvega.rest.jobsearch.model.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.jgvega.rest.jobsearch.entity.Category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OfferResponse implements Serializable {

	private static final long serialVersionUID = 7801041997416805816L;
	
	private Long id;
	private String name;
	private String description;
	private Integer minSalary;
	private Integer maxSalary;
	private String model;
	private String location;
	private Date date;
	private Category category;
	private String status;
	private List<OfferLanguageResponse> languages;

}
