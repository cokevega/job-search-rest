package com.jgvega.rest.jobsearch.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jgvega.rest.jobsearch.commons.entity.Attribute;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name = "skill")
@SuperBuilder
@NoArgsConstructor
public class Skill extends Attribute implements Serializable {

	private static final long serialVersionUID = -6188182183674966879L;

}
