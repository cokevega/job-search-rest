package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.model.commons.UserDb;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "employee")
@SuperBuilder
@NoArgsConstructor
public class Employee extends UserDb implements Serializable {

	private static final long serialVersionUID = -5869837062603607960L;

	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(nullable = false)
	private Date born;
	@Pattern(regexp = "^(\\(|\\)|\\-|\\s|\\d|\\.){9,16}$", message = "Incorrect phone format")
	@Column(columnDefinition = "varchar(" + Constant.MAX_PHONE_LENGTH + ")")
	@Length(min = Constant.MIN_PHONE_LENGTH, max = Constant.MAX_PHONE_LENGTH)
	private String phone;
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
	private List<Education> education;
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
	private List<Experience> experiences;
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
	private List<Skill> skills;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Application> applications;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EmployeeLanguage> languages;
}
