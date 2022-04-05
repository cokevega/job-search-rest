package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name="skill")
@SuperBuilder
public class Skill extends Attribute implements Serializable {

	private static final long serialVersionUID = -6188182183674966879L;

}
