package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.jgvega.rest.jobsearch.enumeration.ApplicationStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "application")
@NoArgsConstructor
public class Application implements Serializable {

	private static final long serialVersionUID = -3495615916265847083L;
	
	public Application(Long id, @NotNull Date createAt, String comments, @NotNull ApplicationStatus status, Offer offer,
			Set<Employee> employees) {
		this.id = id;
		this.createAt = createAt;
		this.comments = comments;
		this.status = status;
		this.offer = offer;
		this.employees = employees;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date createAt;
	@Column(columnDefinition = "varchar(1024)", length = 1024)
	private String comments;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ApplicationStatus status;
	@ManyToOne()
	@JoinColumn(name = "offer_id")
	private Offer offer;
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "employee_application", joinColumns = {@JoinColumn(name="application_id")}, inverseJoinColumns = {@JoinColumn(name="employee_id")})
	private Set<Employee> employees;
	
}
