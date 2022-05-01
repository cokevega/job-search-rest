package com.jgvega.rest.jobsearch.commons.entity;

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

import com.jgvega.rest.jobsearch.util.Constant;
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
	@Length(max = Constant.MAX_LENGTH_EMAIL)
	@Email
	@Column(nullable = false, length = Constant.MAX_LENGTH_EMAIL, columnDefinition = "varchar("
			+ Constant.MAX_LENGTH_EMAIL + ")", unique = true)
	private String email;
	@NotBlank
	@Length(min = Constant.MIN_LENGTH_PASSWORD, max = Constant.MAX_LENGTH_PASSWORD)
	@Column(nullable = false, length = Constant.MAX_LENGTH_PASSWORD, columnDefinition = "varchar("
			+ Constant.MAX_LENGTH_PASSWORD + ")")
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
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

	@Override
	public boolean equals(Object obj) {
		return email.equals(((UserDb) obj).getEmail());
	}

	@Override
	public int hashCode() {
		return email.hashCode();
	}

}
