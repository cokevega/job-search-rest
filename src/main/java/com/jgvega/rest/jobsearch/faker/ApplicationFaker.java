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
public class ApplicationFaker implements CommandLineRunner {

	@Autowired
	private IApplicationService service;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IOfferService offerService;
	private final Faker faker = Faker.instance();
	private List<Application> fakeApplications;
	private List<Employee> employees;
	private List<Offer> offers;

	@Override
	public void run(String... args) throws Exception {
		init();
		fakeApplications = LongStream.rangeClosed(1, Constant.APPLICATION_NUMBER).mapToObj(this::createFakeApplication)
				.collect(Collectors.toList());
		service.saveAll(fakeApplications);
		log.info("Fake applications created successfully");
		log.info("Finished fake data creation");
		System.exit(0);
	}

	private void init() {
		employees = employeeService.findAll();
		offers = offerService.findAll();
	}

	private Application createFakeApplication(long i) {
		return Application.builder().comments(faker.lorem().paragraph(Constant.SENTENCES_APPLICATION_COMMENTS))
				.employee(employees.get(faker.number().numberBetween(0, employees.size())))
				.offer(offers.get(faker.number().numberBetween(0, offers.size())))
				.status(ApplicationStatus.values()[faker.number().numberBetween(0, ApplicationStatus.values().length)])
				.build();
	}

}
