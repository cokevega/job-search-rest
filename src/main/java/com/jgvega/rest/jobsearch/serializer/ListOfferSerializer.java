package com.jgvega.rest.jobsearch.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.model.response.OfferResponseFromEnterprise;

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
		List<OfferResponseFromEnterprise> offers=new ArrayList<OfferResponseFromEnterprise>();
		offers=value.stream().map(this::parseOffer).collect(Collectors.toList());
		gen.writeObject(offers);
	}

	private OfferResponseFromEnterprise parseOffer(Offer offer) {
		OfferResponseFromEnterprise offerResponse = OfferResponseFromEnterprise.builder().category(offer.getCategory())
				.date(offer.getDate()).description(offer.getDescription()).id(offer.getId()).languages(offer.getLanguages())
				.location(offer.getLocation()).maxSalary(offer.getMaxSalary())
				.minEducationLevel(offer.getMinEducationLevel().toString()).minSalary(offer.getMinSalary())
				.model(offer.getModel().toString()).name(offer.getName()).status(offer.getStatus().toString()).build();
		return offerResponse;
	}

}
