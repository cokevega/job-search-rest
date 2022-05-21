package com.jgvega.rest.jobsearch.model.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.serializer.ListOfferLanguageSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class OfferResponseFromEnterprise implements Serializable {

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
	private String minEducationLevel;
	private String status;
	@JsonSerialize(using = ListOfferLanguageSerializer.class)
	private List<OfferLanguage> languages;

}
