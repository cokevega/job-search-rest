package com.jgvega.rest.jobsearch.commons.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.jgvega.rest.jobsearch.enumeration.Level;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Attribute extends CommonModel implements Serializable {

	private static final long serialVersionUID = -6188182183674966879L;

	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level level;

}
