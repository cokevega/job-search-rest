package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.commons.model.CommonModel;
import com.jgvega.rest.jobsearch.enumeration.EducationLevel;
import com.jgvega.rest.jobsearch.enumeration.OfferStatus;
import com.jgvega.rest.jobsearch.enumeration.WorkModel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name = "offer")
@SuperBuilder
public class Offer extends CommonModel implements Serializable {

	private static final long serialVersionUID = -6120846272017329568L;

	@NotBlank
	@Length(min = 50, max = 1024)
	@Column(nullable = false, length = 1024,columnDefinition = "varchar(1024)")
	private String description;
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "offer")
	private List<Application> applications;
	@ManyToOne()
	@JoinColumn(name="enterprise_id")
	private Enterprise enterprise;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OfferStatus status;

	@PrePersist
	public void create_at() {
		this.date = new Date();
	}

}
