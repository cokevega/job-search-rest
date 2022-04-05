package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

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

}
