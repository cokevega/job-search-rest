package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "enterprise")
@SuperBuilder
@NoArgsConstructor
public class Enterprise extends UserDb implements Serializable {

	private static final long serialVersionUID = -333134196983909116L;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "enterprise")
	private List<Offer> offers;
	@Length(max = Constant.MAX_LENGTH_ENTERPRISE_DESCRIPTION)
	@Column(length = Constant.MAX_LENGTH_ENTERPRISE_DESCRIPTION, columnDefinition = "text")
	private String description;

}
