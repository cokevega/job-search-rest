package com.jgvega.rest.jobsearch.model.request;

import java.util.List;

import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeFilterRequest {

	private String name;
	private String email;
	private UserStatus status;
	private Integer minAge;
	private Integer maxAge;
	private List<EmployeeLanguage> languages;
	private List<String> keywords;
	
}
