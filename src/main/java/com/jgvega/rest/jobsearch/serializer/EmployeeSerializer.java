package com.jgvega.rest.jobsearch.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.model.response.EmployeeResponse;

public class EmployeeSerializer extends StdSerializer<Employee> {

	private static final long serialVersionUID = -9008639463078654961L;

	protected EmployeeSerializer(Class<Employee> t) {
		super(t);
	}

	public EmployeeSerializer() {
		this(null);
	}

	@Override
	public void serialize(Employee value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		EmployeeResponse employeeResponse = EmployeeResponse.builder().born(value.getBorn())
				.createAt(value.getCreateAt()).education(value.getEducation()).email(value.getEmail())
				.experiences(value.getExperiences()).id(value.getId()).status(value.getStatus())
				.languages(value.getLanguages()).name(value.getName()).phone(value.getPhone()).skills(value.getSkills())
				.build();
		gen.writeObject(employeeResponse);
	}

}
