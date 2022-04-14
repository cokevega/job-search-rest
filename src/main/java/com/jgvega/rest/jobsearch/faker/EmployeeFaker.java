package com.jgvega.rest.jobsearch.faker;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.model.entity.Education;
import com.jgvega.rest.jobsearch.model.entity.Employee;
import com.jgvega.rest.jobsearch.model.entity.Experience;
import com.jgvega.rest.jobsearch.repository.IEmployeeRepository;
import com.jgvega.rest.jobsearch.service.EmployeeService;
import com.jgvega.rest.jobsearch.util.Constant;
import com.jgvega.rest.jobsearch.util.Util;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 3)
public class EmployeeFaker implements CommandLineRunner {

	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	private final Faker faker = Faker.instance(
			Locale.lookup(LanguageRange.parse("es-Es,en-UK,en-US"), Arrays.asList(Locale.getAvailableLocales())));
	private List<Employee> fakerEmployees;

	@Override
	public void run(String... args) throws Exception {
		fakerEmployees = LongStream.rangeClosed(1, Constant.EMPLOYEE_NUMBER).mapToObj(this::createFakeEmployee)
				.collect(Collectors.toList());
		LongStream.rangeClosed(1, Constant.EDUCATION_NUMBER).forEach(this::createFakeEducation);
		employeeRepository.saveAll(fakerEmployees);
		fakerEmployees=employeeRepository.findAll();
		LongStream.rangeClosed(1, Constant.EXPERIENCE_NUMBER).forEach(this::createFakeExperience);
		employeeRepository.saveAll(fakerEmployees);
	}

	private Employee createFakeEmployee(long i) {
		return Employee.builder().born(faker.date().birthday(Constant.MIN_AGE, Constant.MAX_AGE))
				.createAt(faker.date().birthday(0, Constant.FAKE_YEARS_APP)).email(faker.internet().emailAddress())
				.id(i).name(faker.name().fullName()).password(faker.internet().password())
				.phone(faker.phoneNumber().cellPhone())
				.status(UserStatus.values()[faker.number().numberBetween(0, UserStatus.values().length)]).build();
	}

	private void createFakeEducation(long i) {
		int index = faker.number().numberBetween(0, fakerEmployees.size());
		Employee employee = fakerEmployees.get(index);
		Date now = new Date();
		Date beginDate = faker.date().between(employee.getBorn(), now);
		Education fakeEducation = Education.builder().beginDate(beginDate).center(faker.educator().university())
				.city(faker.address().city()).endDate(faker.date().between(beginDate, now)).id(i)
				.name(faker.job().title()).build();
		employee = employeeService.addEducation(employee, fakeEducation);
		fakerEmployees.set(index, employee);
	}

	private void createFakeExperience(long i) {
		int index = faker.number().numberBetween(0, fakerEmployees.size());
		Employee employee = fakerEmployees.get(index);
		Date now = new Date();
		Date beginDate = faker.date().between(Util.getDate(Util.getLocalDate(employee.getBorn()).plusYears(Constant.MIN_AGE)), now);
		Experience fakeExperience = Experience.builder().begin(beginDate).city(faker.address().city())
				.end(faker.date().between(beginDate, now)).enterprise(faker.company().name()).id(i)
				.name(faker.job().position()).build();
		employee = employeeService.addExperience(employee, fakeExperience);
		fakerEmployees.set(index, employee);
	}

}
