package com.jgvega.rest.jobsearch.model.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jgvega.rest.jobsearch.entity.Education;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.Experience;
import com.jgvega.rest.jobsearch.entity.Skill;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.serializer.ListEmployeeLanguageSerializer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponse {

	private Long id;
	private String name;
	private String email;
	private Date createAt;
	private UserStatus status;
	private Date born;
	private String phone;
	private List<Education> education;
	private List<Experience> experiences;
	private List<Skill> skills;
	@JsonSerialize(using = ListEmployeeLanguageSerializer.class)
	private List<EmployeeLanguage> languages;

}
