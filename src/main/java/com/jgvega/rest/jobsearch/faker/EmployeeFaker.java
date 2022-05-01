package com.jgvega.rest.jobsearch.faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.LongStream;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jgvega.rest.jobsearch.commons.faker.CommonFaker;
import com.jgvega.rest.jobsearch.entity.Education;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.Experience;
import com.jgvega.rest.jobsearch.entity.Language;
import com.jgvega.rest.jobsearch.entity.Skill;
import com.jgvega.rest.jobsearch.entity.key.EmployeeLanguageKey;
import com.jgvega.rest.jobsearch.enumeration.Level;
import com.jgvega.rest.jobsearch.enumeration.UserStatus;
import com.jgvega.rest.jobsearch.service.IEmployeeLanguageService;
import com.jgvega.rest.jobsearch.service.IEmployeeService;
import com.jgvega.rest.jobsearch.service.ILanguageService;
import com.jgvega.rest.jobsearch.util.Constant;
import com.jgvega.rest.jobsearch.util.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("data")
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@Slf4j
public class EmployeeFaker extends CommonFaker<Employee> {

	@Autowired
	private IEmployeeService service;
	@Autowired
	private ILanguageService languageService;
	@Autowired
	private IEmployeeLanguageService employeeLanguageService;

	@Override
	public void run(String... args) throws Exception {
		init();
		LongStream.rangeClosed(1, Constant.EMPLOYEE_NUMBER).forEach(this::createFakeEntity);
		service.saveAll(fakeEntities);
		log.info("Fake employees created successfully with basic information");
		fakeEntities = service.findAll();
		LongStream.rangeClosed(1, Constant.EDUCATION_NUMBER).forEach(this::createFakeEducation);
		log.info("Fake employees' education created successfully");
		LongStream.rangeClosed(1, Constant.EXPERIENCE_NUMBER).forEach(this::createFakeExperience);
		log.info("Fake employees' experiences created successfully");
		LongStream.rangeClosed(1, Constant.SKILL_NUMBER).forEach(this::createFakeSkill);
		log.info("Fake employees' skills created successfully");
		LongStream.rangeClosed(1, Constant.EMPLOYEE_LANGUAGE_NUMBER).forEach(this::createFakeLanguage);
		log.info("Fake employees' languages created successfully");
	}

	@Override
	protected void init() {
		fakeEntities = new ArrayList<Employee>();
		log.info("Initiating employees fake data creation");
	}

	@Override
	protected void createFakeEntity(long i) {
		Employee employee;
		String email;
		do {
			email = faker.internet().emailAddress();
			employee = Employee.builder().born(faker.date().birthday(Constant.MIN_AGE, Constant.MAX_AGE))
					.createAt(faker.date().birthday(0, Constant.FAKE_YEARS_APP)).email(email)
					.name(faker.name().fullName()).password(faker.internet().password())
					.phone(faker.phoneNumber().cellPhone())
					.status(UserStatus.values()[faker.number().numberBetween(0, UserStatus.values().length)]).build();
		} while (!validateCreatedEntity(employee));
		fakeEntities.add(employee);
	}

	private void createFakeEducation(long i) {
		int index = faker.number().numberBetween(0, fakeEntities.size());
		Employee employee = ((List<Employee>) fakeEntities).get(index);
		Date now = new Date();
		Date beginDate = faker.date().between(employee.getBorn(), now);
		Education fakeEducation = Education.builder().beginDate(beginDate).center(faker.educator().university())
				.city(faker.address().city()).endDate(faker.date().between(beginDate, now)).name(faker.job().title())
				.build();
		employee = service.addEducation(employee, fakeEducation);
		((List<Employee>) fakeEntities).set(index, employee);
	}

	private void createFakeExperience(long i) {
		int index = faker.number().numberBetween(0, fakeEntities.size());
		Employee employee = ((List<Employee>) fakeEntities).get(index);
		Date now = new Date();
		Date beginDate = faker.date()
				.between(Util.getDate(Util.getLocalDate(employee.getBorn()).plusYears(Constant.MIN_AGE)), now);
		Experience fakeExperience = Experience.builder().begin(beginDate).city(faker.address().city())
				.comments(faker.lorem().paragraph()).end(faker.date().between(beginDate, now))
				.enterprise(faker.company().name()).name(faker.job().position()).build();
		employee = service.addExperience(employee, fakeExperience);
		((List<Employee>) fakeEntities).set(index, employee);
	}

	private void createFakeSkill(long i) {
		int index = faker.number().numberBetween(0, fakeEntities.size());
		Employee employee = ((List<Employee>) fakeEntities).get(index);
		Skill fakeSkill = Skill.builder().level(Level.values()[faker.number().numberBetween(0, Level.values().length)])
				.name(faker.job().keySkills()).build();
		employee = service.addSkill(employee, fakeSkill);
		((List<Employee>) fakeEntities).set(index, employee);
	}

	private void createFakeLanguage(long i) {
		int index, indexLanguage;
		EmployeeLanguageKey employeeLanguageKey;
		List<Language> languages = languageService.findAll();
		boolean continueLoop = true;
		do {
			index = faker.number().numberBetween(0, fakeEntities.size());
			indexLanguage = faker.number().numberBetween(1, languages.size());
			employeeLanguageKey = EmployeeLanguageKey.builder()
					.employeeId(((List<Employee>) fakeEntities).get(index).getId())
					.languageId(languages.get(indexLanguage).getId()).build();
			try {
				employeeLanguageService.findById(employeeLanguageKey);
			} catch (EntityNotFoundException e) {
				continueLoop = false;
			}
		} while (continueLoop);
		Employee employee = ((List<Employee>) fakeEntities).get(index);
		Language language = languages.get(indexLanguage);
		EmployeeLanguage employeeLanguage = EmployeeLanguage.builder().id(employeeLanguageKey).employee(employee)
				.language(language).level(Level.values()[faker.number().numberBetween(0, Level.values().length)])
				.build();
		employee = service.addLanguage(employee, employeeLanguage);
		((List<Employee>) fakeEntities).set(index, employee);
	}

}
