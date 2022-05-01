package com.jgvega.rest.jobsearch.commons.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.util.Constant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CommonModel implements Serializable {

	private static final long serialVersionUID = -8196181035133213075L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(length = Constant.MAX_LENGTH_NAME, nullable = false, columnDefinition = "varchar("
			+ Constant.MAX_LENGTH_NAME + ")")
	@Length(max = Constant.MAX_LENGTH_NAME)
	protected String name;

	@Override
	public boolean equals(Object obj) {
		CommonModel o2 = (CommonModel) obj;
		return this.id == o2.getId();
	}

}
