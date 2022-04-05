package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
public class UserDb implements Serializable {

	private static final long serialVersionUID = -5010586986703337868L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Length(min = 20, max = 100)
	@Column(nullable = false, length = 100, columnDefinition = "varchar(100)")
	private String name;
	@NotBlank
	@Length(max = 100)
	@Email
	@Column(nullable = false, length = 100, columnDefinition = "varchar(100)")
	private String email;
	@NotBlank
	@Length(min = 20, max = 100)
	@Column(nullable = false, length = 100, columnDefinition = "varchar(100)")
	private String password;
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name = "create_at", nullable = false)
	private Date createAt;

	@PrePersist
	public void create_at() {
		this.createAt = new Date();
	}

}
