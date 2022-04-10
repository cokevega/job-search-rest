package com.jgvega.rest.jobsearch.faker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jgvega.rest.jobsearch.model.entity.Category;
import com.jgvega.rest.jobsearch.repository.ICategoryRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CategoryFaker implements CommandLineRunner {

	private final Faker faker = new Faker();
	@Autowired
	private ICategoryRepository repository;

	@Override
	public void run(String... args) throws Exception {
		List<Category> fakeCategories = LongStream.rangeClosed(1, Constant.CATEGORY_NUMBER)
				.mapToObj(i -> new Category(i, faker.job().field(), faker.job().title())).collect(Collectors.toList());
		repository.saveAll(fakeCategories);
	}

}
