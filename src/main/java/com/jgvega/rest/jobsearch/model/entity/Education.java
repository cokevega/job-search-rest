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

import com.jgvega.rest.jobsearch.util.Constant;
import com.jgvega.rest.jobsearch.model.commons.CommonModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name = "education")
@SuperBuilder
@NoArgsConstructor
public class Education extends CommonModel implements Serializable {

	private static final long serialVersionUID = 95005091825546579L;

	@NotBlank
	@Length(max = Constant.MAX_LENGTH_CITY)
	@Column(length = Constant.MAX_LENGTH_CITY, nullable = false, columnDefinition = "varchar("
			+ Constant.MAX_LENGTH_CITY + ")")
	private String city;
	@Length(min = Constant.MIN_LENGTH_CENTER, max = Constant.MAX_LENGTH_CENTER)
	@Column(nullable = false, length = Constant.MAX_LENGTH_CENTER, columnDefinition = "varchar("
			+ Constant.MAX_LENGTH_CENTER + ")")
	@NotBlank
	private String center;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "begin", nullable = false)
	private Date beginDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "end")
	private Date endDate;

}
