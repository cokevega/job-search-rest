package com.jgvega.rest.jobsearch.faker;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jgvega.rest.jobsearch.model.entity.Language;
import com.jgvega.rest.jobsearch.model.other.CountryResponse;
import com.jgvega.rest.jobsearch.util.Util;

//@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LanguageFaker implements CommandLineRunner {

//	@Value("${languages.creation.endpoint.languages}")
//	private String endpoint;
//	private List<Language> languages;
	
	@Override
	public void run(String... args) throws Exception {
//		getCountries(endpoint);
	}
//	
//	private void getCountries(String endpoint) {
//		 List<CountryResponse> countries=Arrays.asList(Util.getFromAnotherApi(endpoint, CountryResponse[].class));
//		 countries.stream().forEach();
//	}
//	
//	private Language convertLanguage(CountryResponse country) {
//		return Language.builder().name(country.getla language.getName()).build();
//	}
	
}
