package com.jgvega.rest.jobsearch.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jgvega.rest.jobsearch.commons.model.CommonModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "language")
@SuperBuilder
@NoArgsConstructor
public class Language extends CommonModel implements Serializable {

	private static final long serialVersionUID = 7696520098740984475L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
	private List<EmployeeLanguage> employees;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
	private List<OfferLanguage> offers;

	@Override
	public boolean equals(Object obj) {
		return ((Language)obj).getName().equals(this.getName());
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}

}
