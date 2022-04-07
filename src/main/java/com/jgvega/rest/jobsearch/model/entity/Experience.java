package com.jgvega.rest.jobsearch.model.entity;

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

import com.jgvega.rest.jobsearch.commons.model.CommonModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "experience")
public class Experience extends CommonModel implements Serializable {

	private static final long serialVersionUID = 5814969490078999132L;

	public Experience() {
		super();
	}

	public Experience(Long id, @NotBlank @Length(max = 100) String name,
			@NotBlank @Length(min = 5, max = 64) String enterprise, @NotNull Date begin, Date end,
			@Length(max = 64) String comments, @NotBlank @Length(min = 5, max = 64) String city) {
		super(id, name);
		this.enterprise = enterprise;
		this.begin = begin;
		this.end = end;
		this.comments = comments;
		this.city = city;
	}

	@NotBlank
	@Length(min = 5, max = 64)
	@Column(columnDefinition = "varchar(64)", nullable = false, length = 64)
	private String enterprise;
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(nullable = false)
	private Date begin;
	@Temporal(TemporalType.DATE)
	private Date end;
	@Length(max = 64)
	@Column(columnDefinition = "varchar(64)", length = 64)
	private String comments;
	@NotBlank
	@Length(min = 5, max = 64)
	@Column(columnDefinition = "varchar(64)", nullable = false, length = 64)
	private String city;

}
