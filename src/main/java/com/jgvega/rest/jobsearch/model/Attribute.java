package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.commons.model.CommonModel;
import com.jgvega.rest.jobsearch.enumeration.Level;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Attribute extends CommonModel implements Serializable {

	private static final long serialVersionUID = -6188182183674966879L;

	public Attribute() {
		super();
	}

	public Attribute(Long id, @NotBlank @Length(max = 100) String name, @NotNull @Length(max = 50) Level level) {
		super(id, name);
		this.level = level;
	}

	@NotNull
	@Column(nullable = false)
	@Length(max = 50)
	@Enumerated(EnumType.STRING)
	private Level level;

}
