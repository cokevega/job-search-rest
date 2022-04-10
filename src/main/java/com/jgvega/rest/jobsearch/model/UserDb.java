package com.jgvega.rest.jobsearch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.commons.model.CommonModel;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserDb extends CommonModel implements Serializable {

	private static final long serialVersionUID = -5010586986703337868L;

	@NotBlank
	@Length(max = 100)
	@Email
	@Column(nullable = false, length = 100, columnDefinition = "varchar(100)", unique = true)
	private String email;
	@NotBlank
	@Length(min = 20, max = 100)
	@Column(nullable = false, length = 100, columnDefinition = "varchar(100)")
	private String password;
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name = "create_at", nullable = false)
	private Date createAt;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@NotNull
	private UserStatus status;

	@PrePersist
	public void create_at() {
		this.createAt = new Date();
	}

}
