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
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.service.ICategoryService;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CategoryFaker implements CommandLineRunner {

	/**
	 * Spanish // UK English // American English
	 */
//	private final Faker faker = Faker.instance(
//			Locale.lookup(LanguageRange.parse("es-Es,en-UK,en-US"), Arrays.asList(Locale.getAvailableLocales())));
	
	private final Faker faker = Faker.instance();
	@Autowired
	private ICategoryService service;

	@Override
	public void run(String... args) throws Exception {
		List<Category> fakeCategories = LongStream.rangeClosed(1, Constant.CATEGORY_NUMBER)
				.mapToObj(this::createFakeCategory).collect(Collectors.toList());
		service.saveAll(fakeCategories);
		log.info("Fake categories created successfully");
	}

	private Category createFakeCategory(long i) {
		return Category.builder().id(i).name(faker.job().field()).description(faker.lorem().paragraph()).build();
	}

}
