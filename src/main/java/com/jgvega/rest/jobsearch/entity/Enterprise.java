package com.jgvega.rest.jobsearch.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.serializer.EnterpriseSerializer;
import com.jgvega.rest.jobsearch.serializer.ListOfferSerializer;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "enterprise")
@SuperBuilder
@NoArgsConstructor
@JsonSerialize(using = EnterpriseSerializer.class)
public class Enterprise extends UserDb implements Serializable {

	private static final long serialVersionUID = -333134196983909116L;

	@Length(max = Constant.MAX_LENGTH_ENTERPRISE_DESCRIPTION)
	@Column(length = Constant.MAX_LENGTH_ENTERPRISE_DESCRIPTION, columnDefinition = "text")
	private String description;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "enterprise")
	@JsonSerialize(using = ListOfferSerializer.class)
	private List<Offer> offers;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
