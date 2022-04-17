package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jgvega.rest.jobsearch.enumeration.Level;
import com.jgvega.rest.jobsearch.model.entity.key.EmployeeLanguageKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_language")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeLanguage implements Serializable {

	private static final long serialVersionUID = -1187709929923570265L;

	@EmbeddedId
	private EmployeeLanguageKey id;
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level level;
	@ManyToOne
	@MapsId("employeeId")
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@ManyToOne
	@MapsId("languageId")
	@JoinColumn(name = "language_id")
	private Language language;
	
}
