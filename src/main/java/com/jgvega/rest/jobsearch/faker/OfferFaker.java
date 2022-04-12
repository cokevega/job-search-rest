package com.jgvega.rest.jobsearch.faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jgvega.rest.jobsearch.constant.Constant;
import com.jgvega.rest.jobsearch.enumeration.EducationLevel;
import com.jgvega.rest.jobsearch.enumeration.OfferStatus;
import com.jgvega.rest.jobsearch.enumeration.WorkModel;
import com.jgvega.rest.jobsearch.model.entity.Category;
import com.jgvega.rest.jobsearch.model.entity.Enterprise;
import com.jgvega.rest.jobsearch.model.entity.Offer;
import com.jgvega.rest.jobsearch.repository.ICategoryRepository;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;
import com.jgvega.rest.jobsearch.repository.IOfferRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class OfferFaker implements CommandLineRunner {

	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private IEnterpriseRepository enterpriseRepository;
	@Autowired
	private IOfferRepository offerRepository;
	private final Faker faker = Faker.instance(
			Locale.lookup(LanguageRange.parse("es-Es,en-UK,en-US"), Arrays.asList(Locale.getAvailableLocales())));

	@Override
	public void run(String... args) throws Exception {
		List<Category> categories = categoryRepository.findAll();
		List<Enterprise> enterprises = enterpriseRepository.findAll();
		int maxSalary = faker.number().numberBetween(0, Integer.MAX_VALUE);
		List<Offer> fakeOffers = LongStream.rangeClosed(1, Constant.OFFER_NUMBER).mapToObj(i -> Offer.builder()
				.category(categories.get(faker.number().numberBetween(0, categories.size())))
				.description(faker.lorem().paragraph().concat("\n" + faker.lorem().paragraph()))
				.enterprise(enterprises.get(faker.number().numberBetween(0, enterprises.size()))).id(i)
				.location(faker.address().city()).minSalary(faker.number().numberBetween(0, maxSalary))
				.maxSalary(maxSalary)
				.minEducationLevel(
						EducationLevel.values()[faker.number().numberBetween(0, EducationLevel.values().length)])
				.model(WorkModel.values()[faker.number().numberBetween(0, WorkModel.values().length)])
				.name(faker.job().title())
				.status(OfferStatus.values()[faker.number().numberBetween(0, OfferStatus.values().length)]).build())
				.collect(Collectors.toList());
		offerRepository.saveAll(fakeOffers);
	}

}
