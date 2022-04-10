package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jgvega.rest.jobsearch.model.UserDb;

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "enterprise")
	private List<Offer> offers;

}
