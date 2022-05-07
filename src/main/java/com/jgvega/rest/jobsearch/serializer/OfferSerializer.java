package com.jgvega.rest.jobsearch.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.model.response.EnterpriseResponseFromOffer;
import com.jgvega.rest.jobsearch.model.response.OfferLanguageResponse;
import com.jgvega.rest.jobsearch.model.response.OfferResponse;

public class OfferSerializer extends StdSerializer<Offer> {

	private static final long serialVersionUID = 1883764481689096977L;

	public OfferSerializer() {
		this(null);
	}

	protected OfferSerializer(Class<Offer> t) {
		super(t);
	}

	@Override
	public void serialize(Offer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		List<OfferLanguageResponse> offerLanguages = new ArrayList<OfferLanguageResponse>();
		value.getLanguages().forEach(ol -> parseOfferLanguage(ol, offerLanguages));
		OfferResponse offerResponse = OfferResponse.builder().category(value.getCategory()).date(value.getDate())
				.description(value.getDescription()).enterprise(parseEnterprise(value.getEnterprise()))
				.id(value.getId()).languages(offerLanguages).location(value.getLocation())
				.maxSalary(value.getMaxSalary()).minEducationLevel(value.getMinEducationLevel().toString())
				.minSalary(value.getMinSalary()).model(value.getModel().toString()).name(value.getName())
				.status(value.getStatus().toString()).build();
		gen.writeObject(offerResponse);
	}

	private void parseOfferLanguage(OfferLanguage offerLanguage, List<OfferLanguageResponse> offerLanguages) {
		offerLanguages.add(OfferLanguageResponse.builder().id(offerLanguage.getLanguage().getId())
				.level(offerLanguage.getLevel().toString()).name(offerLanguage.getLanguage().getName()).build());
	}

	private EnterpriseResponseFromOffer parseEnterprise(Enterprise enterprise) {
		return EnterpriseResponseFromOffer.builder().createAt(enterprise.getCreateAt())
				.description(enterprise.getDescription()).email(enterprise.getEmail()).id(enterprise.getId())
				.name(enterprise.getName()).status(enterprise.getStatus().toString()).build();
	}

}
