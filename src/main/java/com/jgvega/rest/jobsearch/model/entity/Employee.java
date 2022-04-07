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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.model.UserDb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends UserDb implements Serializable {

	private static final long serialVersionUID = -5869837062603607960L;

	public Employee() {
		super();
	}

	public Employee(Long id, @NotBlank @Length(max = 100) String name, @NotBlank @Length(max = 100) @Email String email,
			@NotBlank @Length(min = 20, max = 100) String password, @NotNull Date createAt, @NotNull UserStatus status,
			@NotNull Date born,
			@Pattern(regexp = "^\\d{3}\\s*(\\d{2}\\s*){3}$", message = "Accepted formats:\n-XXXXXXXXX\n-XXX XX XX XX") @Length(min = 9, max = 12) String phone,
			List<Education> education, List<Experience> experiences, List<Skill> skills, Set<Language> languages,
			Set<Application> applications) {
		super(id, name, email, password, createAt, status);
		this.born = born;
		this.phone = phone;
		this.education = education;
		this.experiences = experiences;
		this.skills = skills;
		this.languages = languages;
		this.applications = applications;
	}

	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(nullable = false)
	private Date born;
	@Pattern(regexp = "^\\d{3}\\s*(\\d{2}\\s*){3}$", message = "Accepted formats:\n-XXXXXXXXX\n-XXX XX XX XX")
	@Column(columnDefinition = "varchar(12)")
	@Length(min = 9, max = 12)
	private String phone;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "employee_id", nullable = false)
	private List<Education> education;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "employee_id", nullable = false)
	private List<Experience> experiences;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "employee_id", nullable = false)
	private List<Skill> skills;
	@ManyToMany(mappedBy = "employees")
	private Set<Language> languages;
	@ManyToMany(mappedBy = "employees")
	private Set<Application> applications;

}
