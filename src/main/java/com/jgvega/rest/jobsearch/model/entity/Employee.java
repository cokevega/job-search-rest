package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.constant.Constant;
import com.jgvega.rest.jobsearch.model.commons.UserDb;

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
	@Pattern(regexp = "^(\\d{3}(\\s|\\-|\\.)*){3}$", message = "Accepted formats:\n-XXXXXXXXX\n-XXX XXX XXX\n-XXX.XXX.XXX\n-XXX-XXX-XXX")
	@Column(columnDefinition = "varchar(" + Constant.MAX_PHONE_LENGTH + ")")
	@Length(min = Constant.MIN_PHONE_LENGTH, max = Constant.MAX_PHONE_LENGTH)
	private String phone;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
	private List<Education> education;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
	private List<Experience> experiences;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
	private List<Skill> skills;
	@ManyToMany(mappedBy = "employees")
	private Set<Language> languages;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Application> applications;
}
