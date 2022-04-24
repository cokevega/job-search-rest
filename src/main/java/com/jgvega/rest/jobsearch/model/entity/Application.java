package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.jgvega.rest.jobsearch.enumeration.ApplicationStatus;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "application")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application implements Serializable {

	private static final long serialVersionUID = -3495615916265847083L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	private Date createAt;
	@Column(columnDefinition = "varchar(" + Constant.MAX_LENGTH_APPLICATION_COMMENTS
			+ ")", length = Constant.MAX_LENGTH_APPLICATION_COMMENTS)
	private String comments;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ApplicationStatus status;
	@ManyToOne
	@JoinColumn(name = "offer_id", nullable = false)
	private Offer offer;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Application) obj).getId();
	}

	@PrePersist
	public void create_at() {
		createAt = new Date();
	}

}
