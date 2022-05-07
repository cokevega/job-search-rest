package com.jgvega.rest.jobsearch.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.model.response.ListOfferResponse;
import com.jgvega.rest.jobsearch.model.response.OfferLanguageResponse;

public class ListOfferSerializer extends StdSerializer<List<Offer>> {

	private static final long serialVersionUID = -7919969769798648099L;

	public ListOfferSerializer() {
		this(null);
	}

	public ListOfferSerializer(Class<List<Offer>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Offer> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		List<ListOfferResponse> offers=new ArrayList<ListOfferResponse>();
		offers=value.stream().map(this::parseOffer).collect(Collectors.toList());
		gen.writeObject(offers);
	}

	private ListOfferResponse parseOffer(Offer offer) {
		List<OfferLanguageResponse> offerLanguages = new ArrayList<OfferLanguageResponse>();
		offer.getLanguages().forEach(ol -> parseOfferLanguage(ol, offerLanguages));
		ListOfferResponse offerResponse = ListOfferResponse.builder().category(offer.getCategory())
				.date(offer.getDate()).description(offer.getDescription()).id(offer.getId()).languages(offerLanguages)
				.location(offer.getLocation()).maxSalary(offer.getMaxSalary())
				.minEducationLevel(offer.getMinEducationLevel().toString()).minSalary(offer.getMinSalary())
				.model(offer.getModel().toString()).name(offer.getName()).status(offer.getStatus().toString()).build();
		return offerResponse;
	}

	private void parseOfferLanguage(OfferLanguage offerLanguage, List<OfferLanguageResponse> offerLanguages) {
		offerLanguages.add(OfferLanguageResponse.builder().id(offerLanguage.getLanguage().getId())
				.level(offerLanguage.getLevel().toString()).name(offerLanguage.getLanguage().getName()).build());
	}

}
