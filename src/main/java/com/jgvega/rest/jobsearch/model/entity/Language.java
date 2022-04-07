package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.enumeration.Level;
import com.jgvega.rest.jobsearch.model.Attribute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language")
public class Language extends Attribute implements Serializable {

	private static final long serialVersionUID = 7696520098740984475L;

	public Language() {
		super();
	}

	public Language(Long id, @NotBlank @Length(max = 100) String name, @NotNull @Length(max = 50) Level level,
			Set<Employee> employees) {
		super(id, name, level);
		this.employees = employees;
	}

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "employee_language", joinColumns = { @JoinColumn(name = "language_id") }, inverseJoinColumns = {
			@JoinColumn(name = "employee_id") })
	private Set<Employee> employees;

}
