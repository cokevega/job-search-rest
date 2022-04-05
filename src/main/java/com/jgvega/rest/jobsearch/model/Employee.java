package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "employee")
public class Employee extends UserDb implements Serializable {

	private static final long serialVersionUID = -5869837062603607960L;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(nullable = false)
	private Date born;
	@Pattern(regexp = "^\\d{3}\\s*(\\d{2}\\s*){3}$", message = "Accepted formats:\n-XXXXXXXXX\n-XXX XX XX XX")
	@Column(columnDefinition = "varchar(12)")
	@Length(min=9,max = 12)
	private String phone;
	private List<Education> education;
	private List<Language> languages;
	private List<Experience> experiences;
	private List<Skill> skills;

}
