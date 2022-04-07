package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.enumeration.Level;
import com.jgvega.rest.jobsearch.model.Attribute;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "skill")
public class Skill extends Attribute implements Serializable {

	private static final long serialVersionUID = -6188182183674966879L;

	public Skill() {
		super();
	}

	public Skill(Long id, @NotBlank @Length(max = 100) String name, @NotNull @Length(max = 50) Level level) {
		super(id, name, level);
	}

}
