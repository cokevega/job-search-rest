package com.jgvega.rest.jobsearch.model.entity.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLanguageKey implements Serializable {

	private static final long serialVersionUID = 3816810809663022727L;

	@Column(name = "employee_id")
	private Long employeeId;
	@Column(name = "language_id")
	private Long languageId;
	
	@Override
	public boolean equals(Object obj) {
		return ((EmployeeLanguageKey) obj).getEmployeeId() == employeeId
				&& ((EmployeeLanguageKey) obj).getLanguageId() == languageId;
	}
	
	@Override
	public int hashCode() {
		return (int)(languageId+employeeId);
	}

}
