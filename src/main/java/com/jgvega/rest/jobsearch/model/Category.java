package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = -8469018946421783184L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Length(max = 50)
	@Column(length = 50, nullable = false)
	private String name;
	@NotBlank
	@Length(min = 40, max = 256)
	@Column(length = 256, nullable = false)
	private String description;

}
