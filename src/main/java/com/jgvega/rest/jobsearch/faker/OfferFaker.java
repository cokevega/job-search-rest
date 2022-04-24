package com.jgvega.rest.jobsearch.faker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jgvega.rest.jobsearch.enumeration.EducationLevel;
import com.jgvega.rest.jobsearch.enumeration.OfferStatus;
import com.jgvega.rest.jobsearch.enumeration.WorkModel;
import com.jgvega.rest.jobsearch.model.entity.Category;
import com.jgvega.rest.jobsearch.model.entity.Enterprise;
import com.jgvega.rest.jobsearch.model.entity.Offer;
import com.jgvega.rest.jobsearch.repository.ICategoryRepository;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;
import com.jgvega.rest.jobsearch.repository.IOfferRepository;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@Slf4j
public class OfferFaker implements CommandLineRunner {

	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private IEnterpriseRepository enterpriseRepository;
	@Autowired
	private IOfferRepository offerRepository;
	private final Faker faker = Faker.instance();

	@Override
	public void run(String... args) throws Exception {
		List<Offer> fakeOffers = LongStream.rangeClosed(1, Constant.OFFER_NUMBER).mapToObj(this::createFakeOffer)
				.collect(Collectors.toList());
		offerRepository.saveAll(fakeOffers);
		log.info("Fake offers created successfully");
	}

	private Offer createFakeOffer(long i) {
		List<Category> categories = categoryRepository.findAll();
		List<Enterprise> enterprises = enterpriseRepository.findAll();
		return Offer.builder().category(categories.get(faker.number().numberBetween(0, categories.size())))
				.description(faker.lorem().paragraph().concat("\n" + faker.lorem().paragraph()))
				.enterprise(enterprises.get(faker.number().numberBetween(0, enterprises.size()))).id(i)
				.location(faker.address().city()).minSalary(faker.number().numberBetween(0, Constant.MIN_MAX_SALARY))
				.maxSalary(faker.number().numberBetween(Constant.MIN_MAX_SALARY, Constant.MAX_MAX_SALARY))
				.minEducationLevel(
						EducationLevel.values()[faker.number().numberBetween(0, EducationLevel.values().length)])
				.model(WorkModel.values()[faker.number().numberBetween(0, WorkModel.values().length)])
				.name(faker.job().title())
				.status(OfferStatus.values()[faker.number().numberBetween(0, OfferStatus.values().length)]).build();
	}

}
