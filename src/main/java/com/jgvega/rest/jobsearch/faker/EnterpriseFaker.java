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
import com.jgvega.rest.jobsearch.constant.Constant;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.model.entity.Enterprise;
import com.jgvega.rest.jobsearch.repository.IEnterpriseRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class EnterpriseFaker implements CommandLineRunner {

	@Autowired
	private IEnterpriseRepository enterpriseRepository;
	private final Faker faker = Faker.instance();

	@Override
	public void run(String... args) throws Exception {
		List<Enterprise> fakerEnterprises = LongStream.rangeClosed(1, Constant.ENTERPRISE_NUMBER)
				.mapToObj(i -> Enterprise.builder().createAt(faker.date().birthday(0, Constant.FAKE_YEARS_APP))
						.email(faker.internet().emailAddress()).id(i).name(faker.company().name())
						.password(faker.internet().password())
						.status(UserStatus.values()[faker.number().numberBetween(0, UserStatus.values().length)])
						.build())
				.collect(Collectors.toList());
		enterpriseRepository.saveAll(fakerEnterprises);
	}

}
