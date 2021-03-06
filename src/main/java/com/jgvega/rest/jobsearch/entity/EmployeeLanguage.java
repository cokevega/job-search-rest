package com.jgvega.rest.jobsearch.entity;

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

import com.jgvega.rest.jobsearch.entity.key.EmployeeLanguageKey;
import com.jgvega.rest.jobsearch.enumeration.Level;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_language")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLanguage implements Serializable {

	private static final long serialVersionUID = -1187709929923570265L;

	@EmbeddedId
	private EmployeeLanguageKey id=EmployeeLanguageKey.builder().build();
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

	@Override
	public boolean equals(Object obj) {
		return id.equals(((EmployeeLanguage) obj).getId());
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
