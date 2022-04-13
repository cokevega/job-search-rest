package com.jgvega.rest.jobsearch.faker;

import java.util.Arrays;
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
import com.jgvega.rest.jobsearch.constant.Constant;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.model.entity.Employee;
import com.jgvega.rest.jobsearch.repository.IEmployeeRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE+3)
public class EmployeeFaker implements CommandLineRunner {

	@Autowired
	private IEmployeeRepository employeeRepository;
	private final Faker faker = Faker.instance(
			Locale.lookup(LanguageRange.parse("es-Es,en-UK,en-US"), Arrays.asList(Locale.getAvailableLocales())));

	@Override
	public void run(String... args) throws Exception {
		List<Employee> fakerEmployees = LongStream.rangeClosed(1, Constant.EMPLOYEE_NUMBER)
				.mapToObj(i -> Employee.builder().born(faker.date().birthday(Constant.MIN_AGE, Constant.MAX_AGE))
						.createAt(faker.date().birthday(0, Constant.FAKE_YEARS_APP))
						.email(faker.internet().emailAddress()).id(i).name(faker.name().fullName())
						.password(faker.internet().password()).phone(faker.phoneNumber().cellPhone())
						.status(UserStatus.values()[faker.number().numberBetween(0, UserStatus.values().length)])
						.build())
				.collect(Collectors.toList());
		employeeRepository.saveAll(fakerEmployees);
	}

}
