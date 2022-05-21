package com.jgvega.rest.jobsearch.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.model.response.EntityLanguageResponse;

public class ListOfferLanguageSerializer extends StdSerializer<List<OfferLanguage>> {

	private static final long serialVersionUID = -1193580777823761172L;

	protected ListOfferLanguageSerializer(Class<List<OfferLanguage>> t) {
		super(t);
	}

	public ListOfferLanguageSerializer() {
		this(null);
	}

	@Override
	public void serialize(List<OfferLanguage> value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		List<EntityLanguageResponse> offerLanguages = value.stream().map(ol -> {
			return EntityLanguageResponse.builder().id(ol.getLanguage().getId()).name(ol.getLanguage().getName())
					.level(ol.getLevel().toString()).build();
		}).toList();
		gen.writeObject(offerLanguages);
	}

}
