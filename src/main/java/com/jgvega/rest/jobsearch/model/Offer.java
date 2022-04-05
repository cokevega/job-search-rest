package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.enumeration.EducationLevel;
import com.jgvega.rest.jobsearch.enumeration.WorkModel;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "offer")
public class Offer implements Serializable {

	private static final long serialVersionUID = -6120846272017329568L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Length(min = 50, max = 1024)
	@Column(nullable = false, length = 1024,columnDefinition = "varchar(1024)")
	private String description;
	@NotBlank
	@Length(min = 10, max = 100)
	@Column(nullable = false, length = 100, columnDefinition = "varchar(100)")
	private String title;
	@Column(name = "min_salary", precision = 2)
	private Double minSalary;
	@Column(name = "max_salary", precision = 2)
	private Double maxSalary;
	@NotNull
	@Length(max = 50)
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private WorkModel model;
	@Length(max = 128)
	@Column(length = 128, columnDefinition = "varchar(128)")
	private String location;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "create_at", nullable = false)
	private Date date;
	@NotNull
	@Column(name = "min_education_level", nullable = false)
	@Enumerated(EnumType.STRING)
	private EducationLevel minEducationLevel;
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	@PrePersist
	public void create_at() {
		this.date = new Date();
	}

}
