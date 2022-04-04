package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.enumeration.Level;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
public class Attribute implements Serializable {

	private static final long serialVersionUID = -6188182183674966879L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(length = 100, nullable = false)
	@Length(max = 100)
	private String name;
	@NotNull
	@Column(columnDefinition = "varchar(50)", length = 50, nullable = false)
	@Length(max = 50)
	private Level level;

}
