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
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class EnterpriseFaker implements CommandLineRunner {

	@Autowired
	private IEnterpriseService service;
	private final Faker faker = Faker.instance();

	@Override
	public void run(String... args) throws Exception {
		List<Enterprise> fakerEnterprises = LongStream.rangeClosed(1, Constant.ENTERPRISE_NUMBER)
				.mapToObj(this::createFakeEnterprise).collect(Collectors.toList());
		service.saveAll(fakerEnterprises);
		log.info("Fake enterprises created successfully");
	}

	private Enterprise createFakeEnterprise(long i) {
		return Enterprise.builder().email(faker.internet().emailAddress()).id(i).name(faker.company().name())
				.password(faker.internet().password())
				.status(UserStatus.values()[faker.number().numberBetween(0, UserStatus.values().length)]).build();
	}

}
