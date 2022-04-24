package com.jgvega.rest.jobsearch.entity;

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
import com.jgvega.rest.jobsearch.util.Constant;

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
	@Length(max = Constant.MAX_LENGTH_NAME)
	@Column(columnDefinition = "varchar(" + Constant.MAX_LENGTH_NAME
			+ ")", nullable = false, length = Constant.MAX_LENGTH_NAME)
	private String enterprise;
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(nullable = false)
	private Date begin;
	@Temporal(TemporalType.DATE)
	private Date end;
	@Length(max = Constant.MAX_LENGTH_COMMENTS)
	@Column(columnDefinition = "varchar(" + Constant.MAX_LENGTH_COMMENTS + ")", length = Constant.MAX_LENGTH_COMMENTS)
	private String comments;
	@NotBlank
	@Length(max = Constant.MAX_LENGTH_CITY)
	@Column(columnDefinition = "varchar(" + Constant.MAX_LENGTH_CITY
			+ ")", nullable = false, length = Constant.MAX_LENGTH_CITY)
	private String city;

}
