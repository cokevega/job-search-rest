package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name = "education")
@SuperBuilder
public class Education extends Attribute implements Serializable {

	private static final long serialVersionUID = 95005091825546579L;

	@NotBlank
	@Length(max = 100)
	@Column(length = 100, nullable = false)
	private String city;
	@Length(min = 20, max = 100)
	@Column(nullable = false, length = 100)
	@NotBlank
	private String center;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "begin", nullable = false)
	private Date beginDate;
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name = "end")
	private Date endDate;

}
