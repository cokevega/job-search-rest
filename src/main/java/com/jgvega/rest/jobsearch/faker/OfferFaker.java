package com.jgvega.rest.jobsearch.faker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import com.github.javafaker.Faker;
import com.jgvega.rest.jobsearch.model.entity.Offer;
import com.jgvega.rest.jobsearch.repository.ICategoryRepository;

@Order(1)
public class OfferFaker implements CommandLineRunner {

	@Autowired
	private ICategoryRepository categoryRepository;
	private Faker faker;

	@Override
	public void run(String... args) throws Exception {
//		List<Offer> fakeOffers = LongStream.rangeClosed(1, Constant.OFFER_NUMBER).mapToObj(i -> Offer.builder()
//				.category(categoryRepository.findAll().get(faker.number().numberBetween(1, Constant.CATEGORY_NUMBER)))
//				.date(faker.date().birthday(0, 5))
//				.description(faker.lorem().characters(Constant.MIN_CHARACTERS_OFFER_DESCRIPTION,
//						Constant.MAX_CHARACTERS_OFFER_DESCRIPTION)).enterprise(null)
//				.build()).collect(Collectors.toList());
	}

}
