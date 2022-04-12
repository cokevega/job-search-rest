package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.constant.Constant;
import com.jgvega.rest.jobsearch.enumeration.EducationLevel;
import com.jgvega.rest.jobsearch.enumeration.OfferStatus;
import com.jgvega.rest.jobsearch.enumeration.WorkModel;
import com.jgvega.rest.jobsearch.model.commons.CommonModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Table(name = "offer")
@SuperBuilder
@NoArgsConstructor
public class Offer extends CommonModel implements Serializable {

	private static final long serialVersionUID = -6120846272017329568L;

	@NotBlank
	@Length(min = Constant.MIN_CHARACTERS_OFFER_DESCRIPTION, max = Constant.MAX_CHARACTERS_OFFER_DESCRIPTION)
	@Column(nullable = false, length = Constant.MAX_CHARACTERS_OFFER_DESCRIPTION, columnDefinition = "varchar("
			+ Constant.MAX_CHARACTERS_OFFER_DESCRIPTION + ")")
	private String description;
	@Column(name = "min_salary")
	private Integer minSalary;
	@Column(name = "max_salary")
	private Integer maxSalary;
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private WorkModel model;
	@Length(max = Constant.MAX_LENGTH_OFFER_LOCATION)
	@Column(length = Constant.MAX_LENGTH_OFFER_LOCATION, columnDefinition = "varchar("+Constant.MAX_LENGTH_OFFER_LOCATION+")")
	private String location;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
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
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OfferStatus status;
	@ManyToMany(mappedBy = "offers")
	private Set<Language> languages;

	@PrePersist
	public void create_at() {
		this.date = new Date();
	}

}
