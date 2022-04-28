package com.jgvega.rest.jobsearch.faker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jgvega.rest.jobsearch.commons.faker.CommonFaker;
import com.jgvega.rest.jobsearch.entity.Language;
import com.jgvega.rest.jobsearch.model.CountryResponse;
import com.jgvega.rest.jobsearch.service.ILanguageService;
import com.jgvega.rest.jobsearch.util.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LanguageFaker extends CommonFaker<Language> {

	@Autowired
	private ILanguageService service;
	@Value("${languages.creation.endpoint.languages}")
	private String endpoint;
	private Language languageToAdd;

	private void getCountries(String endpoint) {
		Set<CountryResponse> countries = new HashSet<CountryResponse>(
				Arrays.asList(Util.getFromAnotherRest(endpoint, CountryResponse[].class)));
		countries.forEach(this::convertLanguage);
	}

	private void convertLanguage(CountryResponse country) {
		List<com.jgvega.rest.jobsearch.model.Language> countryLanguages = country.getLanguages();
		for (com.jgvega.rest.jobsearch.model.Language language : countryLanguages) {
			languageToAdd = Language.builder().name(language.getName()).build();
			createFakeEntity(1L);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		init();
		getCountries(endpoint);
		service.saveAll(fakeEntities);
		log.info("Languages from API persisted successfully");
	}

	@Override
	protected void init() {
		log.info("Initiating languages persistence from another Rest service");
		fakeEntities = new HashSet<Language>();
		getCountries(endpoint);
	}

	@Override
	protected void createFakeEntity(long i) {
		fakeEntities.add(languageToAdd);
	}

}
