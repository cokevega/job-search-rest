package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.constant.Constant;
import com.jgvega.rest.jobsearch.model.commons.CommonModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name = "category")
@SuperBuilder
@NoArgsConstructor
public class Category extends CommonModel implements Serializable {

	private static final long serialVersionUID = -8469018946421783184L;

	@NotBlank
	@Length(max = Constant.MAX_CHARACTERS_CATEGORY_DESCRIPTION, min = Constant.MIN_CHARACTERS_CATEGORY_DESCRIPTION)
	@Column(length = Constant.MAX_CHARACTERS_CATEGORY_DESCRIPTION, nullable = false, columnDefinition = "varchar("
			+ Constant.MAX_CHARACTERS_CATEGORY_DESCRIPTION + ")")
	private String description;

}
