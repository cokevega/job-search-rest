package com.jgvega.rest.jobsearch.commons.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class CommonModel implements Serializable {

	private static final long serialVersionUID = -8196181035133213075L;

	public CommonModel() {
	}

	public CommonModel(Long id, @NotBlank @Length(max = 100) String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(length = 100, nullable = false, columnDefinition = "varchar(100)")
	@Length(max = 100)
	private String name;

}
