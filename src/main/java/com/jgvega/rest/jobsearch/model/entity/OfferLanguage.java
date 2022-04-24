package com.jgvega.rest.jobsearch.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jgvega.rest.jobsearch.enumeration.Level;
import com.jgvega.rest.jobsearch.model.entity.key.OfferLanguageKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offer_language")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferLanguage implements Serializable {

	private static final long serialVersionUID = -412611093817476571L;
	
	@EmbeddedId
	private OfferLanguageKey id;
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Level level;
	@ManyToOne
	@MapsId("employeeId")
	@JoinColumn(name = "offer_id")
	private Offer offer;
	@ManyToOne
	@MapsId("languageId")
	@JoinColumn(name = "language_id")
	private Language language;

}
