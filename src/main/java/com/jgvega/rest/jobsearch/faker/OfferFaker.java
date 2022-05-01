package com.jgvega.rest.jobsearch.faker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jgvega.rest.jobsearch.commons.faker.CommonFaker;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.entity.Language;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.entity.key.OfferLanguageKey;
import com.jgvega.rest.jobsearch.enumeration.EducationLevel;
import com.jgvega.rest.jobsearch.enumeration.Level;
import com.jgvega.rest.jobsearch.enumeration.OfferStatus;
import com.jgvega.rest.jobsearch.enumeration.WorkModel;
import com.jgvega.rest.jobsearch.service.ICategoryService;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;
import com.jgvega.rest.jobsearch.service.ILanguageService;
import com.jgvega.rest.jobsearch.service.IOfferLanguageService;
import com.jgvega.rest.jobsearch.service.IOfferService;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@Slf4j
public class OfferFaker extends CommonFaker<Offer> {

	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IEnterpriseService enterpriseService;
	@Autowired
	private IOfferService service;
	@Autowired
	private ILanguageService languageService;
	@Autowired
	private IOfferLanguageService offerLanguageService;

	private List<Category> categories;
	private List<Enterprise> enterprises;
	private List<Language> languages;

	@Override
	public void run(String... args) throws Exception {
		init();
		LongStream.rangeClosed(1, Constant.OFFER_NUMBER).forEach(this::createFakeEntity);
		service.saveAll(fakeEntities);
		log.info("Fake offers created successfully without languages");
		fakeEntities = service.findAll();
		LongStream.rangeClosed(1, Constant.OFFER_LANGUAGE_NUMBER).forEach(this::createFakeLanguage);
		log.info("Fake offers' languages created successfully");
	}

	@Override
	protected void init() {
		log.info("Initiating fake offers data creation");
		fakeEntities = new ArrayList<Offer>();
		categories = categoryService.findAll();
		enterprises = enterpriseService.findAll();
		languages = languageService.findAll();
	}

	private void createFakeLanguage(long i) {
		int index, indexLanguage;
		OfferLanguageKey offerLanguageKey;
		boolean continueLoop = true;
		do {
			index = faker.number().numberBetween(0, fakeEntities.size());
			indexLanguage = faker.number().numberBetween(0, languages.size());
			offerLanguageKey = OfferLanguageKey.builder().languageId(languages.get(indexLanguage).getId())
					.offerId(((List<Offer>) fakeEntities).get(index).getId()).build();
			try {
				offerLanguageService.findById(offerLanguageKey);
			} catch (EntityNotFoundException e) {
				continueLoop = false;
			}
		} while (continueLoop);
		Offer offer = ((List<Offer>) fakeEntities).get(index);
		Language language = languages.get(indexLanguage);
		OfferLanguage offerLanguage = OfferLanguage.builder().id(offerLanguageKey).language(language)
				.level(Level.values()[faker.number().numberBetween(0, Level.values().length)]).offer(offer).build();
		offer = service.addLanguage(offer, offerLanguage);
		((List<Offer>) fakeEntities).set(index, offer);
	}

	@Override
	protected void createFakeEntity(long i) {
		Offer offer = Offer.builder().category(categories.get(faker.number().numberBetween(0, categories.size())))
				.description(faker.lorem().paragraph().concat("\n" + faker.lorem().paragraph()))
				.enterprise(enterprises.get(faker.number().numberBetween(0, enterprises.size()))).id(i)
				.location(faker.address().city()).minSalary(faker.number().numberBetween(0, Constant.MIN_MAX_SALARY))
				.maxSalary(faker.number().numberBetween(Constant.MIN_MAX_SALARY, Constant.MAX_MAX_SALARY))
				.minEducationLevel(
						EducationLevel.values()[faker.number().numberBetween(0, EducationLevel.values().length)])
				.model(WorkModel.values()[faker.number().numberBetween(0, WorkModel.values().length)])
				.name(faker.job().title())
				.status(OfferStatus.values()[faker.number().numberBetween(0, OfferStatus.values().length)]).build();
		fakeEntities.add(offer);
	}

}
