package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.commons.model.CommonModel;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category extends CommonModel implements Serializable {

	private static final long serialVersionUID = -8469018946421783184L;

	public Category() {
		super();
	}

	public Category(Long id, @NotBlank @Length(max = 100) String name,
			@NotBlank @Length(min = 40, max = 256) String description) {
		super(id, name);
		this.description = description;
	}

	@NotBlank
	@Length(min = 40, max = 256)
	@Column(length = 256, nullable = false, columnDefinition = "varchar(256)")
	private String description;

}
