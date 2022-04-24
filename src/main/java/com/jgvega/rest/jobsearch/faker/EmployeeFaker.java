package com.jgvega.rest.jobsearch.faker;

import java.util.Date;
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
import com.jgvega.rest.jobsearch.enumeration.Level;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.model.entity.Education;
import com.jgvega.rest.jobsearch.model.entity.Employee;
import com.jgvega.rest.jobsearch.model.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.model.entity.Experience;
import com.jgvega.rest.jobsearch.model.entity.Language;
import com.jgvega.rest.jobsearch.model.entity.Skill;
import com.jgvega.rest.jobsearch.model.entity.key.EmployeeLanguageKey;
import com.jgvega.rest.jobsearch.repository.IEmployeeLanguageRepository;
import com.jgvega.rest.jobsearch.repository.IEmployeeRepository;
import com.jgvega.rest.jobsearch.repository.ILanguageRepository;
import com.jgvega.rest.jobsearch.service.EmployeeService;
import com.jgvega.rest.jobsearch.util.Constant;
import com.jgvega.rest.jobsearch.util.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@Slf4j
public class EmployeeFaker implements CommandLineRunner {

	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private ILanguageRepository languageRepository;
	@Autowired
	private IEmployeeLanguageRepository employeeLanguageRepository;
	@Autowired
	private EmployeeService employeeService;
	private final Faker faker = Faker.instance();
	private List<Employee> fakerEmployees;

	@Override
	public void run(String... args) throws Exception {
		fakerEmployees = LongStream.rangeClosed(1, Constant.EMPLOYEE_NUMBER).mapToObj(this::createFakeEmployee)
				.collect(Collectors.toList());
		employeeRepository.saveAll(fakerEmployees);
		log.info("Fake employees created successfully");
		fakerEmployees = employeeRepository.findAll();
		LongStream.rangeClosed(1, Constant.EDUCATION_NUMBER).forEach(this::createFakeEducation);
		log.info("Fake educations created successfully");
		LongStream.rangeClosed(1, Constant.EXPERIENCE_NUMBER).forEach(this::createFakeExperience);
		log.info("Fake experiences created successfully");
		LongStream.rangeClosed(1, Constant.SKILL_NUMBER).forEach(this::createFakeSkill);
		log.info("Fake skills created successfully");
		LongStream.rangeClosed(1, Constant.EMPLOYEE_LANGUAGE_NUMBER).forEach(this::createFakeLanguage);
		log.info("Fake employees' languages created successfully");
	}

	private Employee createFakeEmployee(long i) {
		return Employee.builder().born(faker.date().birthday(Constant.MIN_AGE, Constant.MAX_AGE))
				.createAt(faker.date().birthday(0, Constant.FAKE_YEARS_APP)).email(faker.internet().emailAddress())
				.name(faker.name().fullName()).password(faker.internet().password())
				.phone(faker.phoneNumber().cellPhone())
				.status(UserStatus.values()[faker.number().numberBetween(0, UserStatus.values().length)]).build();
	}

	private void createFakeEducation(long i) {
		int index = faker.number().numberBetween(0, fakerEmployees.size());
		Employee employee = fakerEmployees.get(index);
		Date now = new Date();
		Date beginDate = faker.date().between(employee.getBorn(), now);
		Education fakeEducation = Education.builder().beginDate(beginDate).center(faker.educator().university())
				.city(faker.address().city()).endDate(faker.date().between(beginDate, now)).name(faker.job().title())
				.build();
		employee = employeeService.addEducation(employee, fakeEducation);
		fakerEmployees.set(index, employee);
	}

	private void createFakeExperience(long i) {
		int index = faker.number().numberBetween(0, fakerEmployees.size());
		Employee employee = fakerEmployees.get(index);
		Date now = new Date();
		Date beginDate = faker.date()
				.between(Util.getDate(Util.getLocalDate(employee.getBorn()).plusYears(Constant.MIN_AGE)), now);
		Experience fakeExperience = Experience.builder().begin(beginDate).city(faker.address().city())
				.comments(faker.lorem().paragraph()).end(faker.date().between(beginDate, now))
				.enterprise(faker.company().name()).name(faker.job().position()).build();
		employee = employeeService.addExperience(employee, fakeExperience);
		fakerEmployees.set(index, employee);
	}

	private void createFakeSkill(long i) {
		int index = faker.number().numberBetween(0, fakerEmployees.size());
		Employee employee = fakerEmployees.get(index);
		Skill fakeSkill = Skill.builder().level(Level.values()[faker.number().numberBetween(0, Level.values().length)])
				.name(faker.job().keySkills()).build();
		employee = employeeService.addSkill(employee, fakeSkill);
		fakerEmployees.set(index, employee);
	}

	private void createFakeLanguage(long i) {
		int index, indexLanguage;
		EmployeeLanguageKey employeeLanguageKey;
		List<Language> languages = languageRepository.findAll();
		do {
			index = faker.number().numberBetween(0, fakerEmployees.size());
			indexLanguage = faker.number().numberBetween(1, languages.size());
			employeeLanguageKey = EmployeeLanguageKey.builder().employeeId(fakerEmployees.get(index).getId())
					.languageId(languages.get(indexLanguage).getId()).build();
		} while (employeeLanguageRepository.findById(employeeLanguageKey).isPresent());
		Employee employee = fakerEmployees.get(index);
		Language language = languages.get(indexLanguage);
		EmployeeLanguage employeeLanguage = EmployeeLanguage.builder().id(employeeLanguageKey).employee(employee)
				.language(language).level(Level.values()[faker.number().numberBetween(0, Level.values().length)])
				.build();
		employee = employeeService.addLanguage(employee, employeeLanguage);
		fakerEmployees.set(index, employee);
	}
}
