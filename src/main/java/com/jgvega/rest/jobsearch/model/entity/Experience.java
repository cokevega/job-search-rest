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

import com.jgvega.rest.jobsearch.model.commons.CommonModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "experience")
@SuperBuilder
@NoArgsConstructor
public class Experience extends CommonModel implements Serializable {

	private static final long serialVersionUID = 5814969490078999132L;

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
