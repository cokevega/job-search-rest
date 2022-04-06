package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.jgvega.rest.jobsearch.model.Attribute;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "language")
@SuperBuilder
public class Language extends Attribute implements Serializable {

	private static final long serialVersionUID = 7696520098740984475L;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name = "employee_language", joinColumns = {@JoinColumn(name="language_id")}, inverseJoinColumns = {@JoinColumn(name="employee_id")})
	private Set<Employee> employees;

}
