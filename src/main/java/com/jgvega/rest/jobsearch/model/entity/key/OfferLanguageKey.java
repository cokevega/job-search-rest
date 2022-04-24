package com.jgvega.rest.jobsearch.model.entity.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferLanguageKey implements Serializable {

	private static final long serialVersionUID = -8418852179041481440L;

	@Column(name = "offer_id")
	private long offerId;
	@Column(name = "language_id")
	private long languageId;

	@Override
	public boolean equals(Object obj) {
		return ((OfferLanguageKey) obj).getOfferId() == offerId
				&& ((OfferLanguageKey) obj).getLanguageId() == languageId;
	}

	@Override
	public int hashCode() {
		return (int) (offerId + languageId);
	}
}
