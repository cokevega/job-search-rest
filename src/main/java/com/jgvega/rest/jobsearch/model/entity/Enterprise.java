package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.model.UserDb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enterprise")
public class Enterprise extends UserDb implements Serializable {

	private static final long serialVersionUID = -333134196983909116L;

	public Enterprise() {
		super();
	}

	public Enterprise(Long id, @NotBlank @Length(max = 100) String name,
			@NotBlank @Length(max = 100) @Email String email, @NotBlank @Length(min = 20, max = 100) String password,
			@NotNull Date createAt, @NotNull UserStatus status, List<Offer> offers) {
		super(id, name, email, password, createAt, status);
		this.offers = offers;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "enterprise")
	private List<Offer> offers;

}
