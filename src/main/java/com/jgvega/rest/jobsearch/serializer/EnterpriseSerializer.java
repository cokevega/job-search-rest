package com.jgvega.rest.jobsearch.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.model.response.EnterpriseResponse;

public class EnterpriseSerializer extends StdSerializer<Enterprise> {

	private static final long serialVersionUID = -5343197725203918277L;
	
	public EnterpriseSerializer() {
		this(null);
	}

	protected EnterpriseSerializer(Class<Enterprise> t) {
		super(t);
	}

	@Override
	public void serialize(Enterprise value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		EnterpriseResponse response=EnterpriseResponse.builder()
				.createAt(value.getCreateAt()).description(value.getDescription())
				.email(value.getEmail()).id(value.getId()).name(value.getName())
				.offers(value.getOffers())
				.status(value.getStatus())
				.build();
		gen.writeObject(response);
	}

}
