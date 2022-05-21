package com.jgvega.rest.jobsearch.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.model.response.EntityLanguageResponse;

public class ListEmployeeLanguageSerializer extends StdSerializer<List<EmployeeLanguage>> {

	private static final long serialVersionUID = 2025171697365917558L;

	protected ListEmployeeLanguageSerializer(Class<List<EmployeeLanguage>> t) {
		super(t);
	}
	
	public ListEmployeeLanguageSerializer() {
		this(null);
	}

	@Override
	public void serialize(List<EmployeeLanguage> value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		List<EntityLanguageResponse> offerLanguages = value.stream().map(ol -> {
			return EntityLanguageResponse.builder().id(ol.getLanguage().getId()).name(ol.getLanguage().getName())
					.level(ol.getLevel().toString()).build();
		}).toList();
		gen.writeObject(offerLanguages);
	}

}
