package com.jgvega.rest.jobsearch.faker;

import java.util.ArrayList;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jgvega.rest.jobsearch.commons.faker.CommonFaker;
import com.jgvega.rest.jobsearch.entity.Enterprise;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.service.IEnterpriseService;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class EnterpriseFaker extends CommonFaker<Enterprise> {

	@Autowired
	private IEnterpriseService service;

	@Override
	public void run(String... args) throws Exception {
		init();
		LongStream.rangeClosed(1, Constant.ENTERPRISE_NUMBER).forEach(this::createFakeEntity);
		service.saveAll(fakeEntities);
		log.info("Fake enterprises created successfully");
	}

	@Override
	protected void init() {
		log.info("Initiating fake enterprises data creation");
		fakeEntities = new ArrayList<Enterprise>();
	}

	@Override
	protected void createFakeEntity(long i) {
		Enterprise enterprise;
		do {
			enterprise = Enterprise.builder().description(faker.lorem().paragraph(Constant.SENTENCES_ENTERPRISE_DESCRIPTION)).email(faker.internet().emailAddress()).id(i).name(faker.company().name())
					.password(faker.internet().password())
					.status(UserStatus.values()[faker.number().numberBetween(0, UserStatus.values().length)]).build();
		} while (!validateCreatedEntity(enterprise));
		fakeEntities.add(enterprise);
	}

}
