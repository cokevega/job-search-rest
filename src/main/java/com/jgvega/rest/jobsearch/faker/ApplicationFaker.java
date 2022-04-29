package com.jgvega.rest.jobsearch.faker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jgvega.rest.jobsearch.commons.faker.CommonFaker;
import com.jgvega.rest.jobsearch.entity.Application;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.Offer;
import com.jgvega.rest.jobsearch.enumeration.ApplicationStatus;
import com.jgvega.rest.jobsearch.service.IApplicationService;
import com.jgvega.rest.jobsearch.service.IEmployeeService;
import com.jgvega.rest.jobsearch.service.IOfferService;
import com.jgvega.rest.jobsearch.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
@Slf4j
public class ApplicationFaker extends CommonFaker<Application> {

	@Autowired
	private IApplicationService service;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IOfferService offerService;
	private final Faker faker = Faker.instance();
	private List<Employee> employees;
	private List<Offer> offers;

	@Override
	public void run(String... args) throws Exception {
		init();
		LongStream.rangeClosed(1, Constant.APPLICATION_NUMBER).forEach(this::createFakeEntity);
		service.saveAll(fakeEntities);
		log.info("Fake applications created successfully");
		finishFakers(Constant.EXIT_SUCCESS_STATUS);
	}

	@Override
	protected void init() {
		fakeEntities = new ArrayList<Application>();
		employees = employeeService.findAll();
		offers = offerService.findAll();
	}

	@Override
	protected void createFakeEntity(long i) {
		Application application;
		do {
			application = Application.builder()
					.comments(faker.lorem().paragraph(Constant.SENTENCES_APPLICATION_COMMENTS))
					.employee(employees.get(faker.number().numberBetween(0, employees.size())))
					.offer(offers.get(faker.number().numberBetween(0, offers.size()))).status(ApplicationStatus
							.values()[faker.number().numberBetween(0, ApplicationStatus.values().length)])
					.build();
		} while (!validateCreatedEntity(application));
		fakeEntities.add(application);
	}

}
