package com.jgvega.rest.jobsearch.faker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jgvega.rest.jobsearch.model.entity.Language;
import com.jgvega.rest.jobsearch.model.other.CountryResponse;
import com.jgvega.rest.jobsearch.repository.ILanguageRepository;
import com.jgvega.rest.jobsearch.util.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class LanguageFaker implements CommandLineRunner {

	@Autowired
	private ILanguageRepository languageRepository;
	@Value("${languages.creation.endpoint.languages}")
	private String endpoint;
	private Set<Language> languages;
	
	@Override
	public void run(String... args) throws Exception {
		languages=new HashSet<Language>();
		getCountries(endpoint);
		log.info("Languages from API persisted successfully");
	}
	
	private void getCountries(String endpoint) {
		 Set<CountryResponse> countries=new HashSet<CountryResponse>(Arrays.asList(Util.getFromAnotherApi(endpoint, CountryResponse[].class)));
		 countries.forEach(this::convertLanguage);
		 languageRepository.saveAll(languages);
	}
	
	private void convertLanguage(CountryResponse country) {
		List<com.jgvega.rest.jobsearch.model.other.Language> countryLanguages=country.getLanguages();
		for (com.jgvega.rest.jobsearch.model.other.Language language : countryLanguages) {
			Language languageToAdd=Language.builder().name(language.getName()).build();
			languages.add(languageToAdd);
		}
	}
	
}
