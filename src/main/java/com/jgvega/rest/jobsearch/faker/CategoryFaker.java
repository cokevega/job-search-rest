package com.jgvega.rest.jobsearch.faker;

import java.util.ArrayList;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jgvega.rest.jobsearch.commons.faker.CommonFaker;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.service.ICategoryService;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CategoryFaker extends CommonFaker<Category> {

	@Autowired
	private ICategoryService service;

	@Override
	public void run(String... args) throws Exception {
		init();
		LongStream.rangeClosed(1, Constant.CATEGORY_NUMBER).forEach(this::createFakeEntity);
		service.saveAll(fakeEntities);
		log.info("Fake categories created successfully");
	}

	@Override
	protected void init() {
		fakeEntities = new ArrayList<Category>();
		log.info("Initiating fake categories data creation");
	}

	@Override
	protected void createFakeEntity(long i) {
		String name;
		Category category;
		do {
			name = faker.job().field();
			category = Category.builder().name(name).description(faker.lorem().paragraph()).build();
		} while (!validateCreatedEntity(category));
		fakeEntities.add(category);
	}

}
