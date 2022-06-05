package com.jgvega.rest.jobsearch.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.entity.Education;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.Experience;
import com.jgvega.rest.jobsearch.entity.Skill;
import com.jgvega.rest.jobsearch.entity.key.EmployeeLanguageKey;
import com.jgvega.rest.jobsearch.model.request.EmployeeFilterRequest;
import com.jgvega.rest.jobsearch.repository.IEmployeeRepository;
import com.jgvega.rest.jobsearch.service.IEmployeeLanguageService;
import com.jgvega.rest.jobsearch.service.IEmployeeService;
import com.jgvega.rest.jobsearch.util.Util;

@Service
public class EmployeeService extends UserDbService<Employee, Long, IEmployeeRepository> implements IEmployeeService {

	// TODO: refactor how to save skill, education, experience and languages?

	@Autowired
	private IEmployeeLanguageService employeeLanguageService;

	@Override
	public Employee addEducation(Employee employee, Education education) {
		if (employee.getEducation() == null)
			employee.setEducation(new ArrayList<Education>());
		if (!employee.getEducation().contains(education)) {
			employee.getEducation().add(education);
			return repository.save(employee);
		}
		return employee;
	}

	@Override
	public Employee addExperience(Employee employee, Experience experience) {
		if (employee.getExperiences() == null)
			employee.setExperiences(new ArrayList<Experience>());
		if (!employee.getExperiences().contains(experience)) {
			employee.getExperiences().add(experience);
			return repository.save(employee);
		}
		return employee;
	}

	@Override
	public Employee addSkill(Employee employee, Skill skill) {
		if (employee.getSkills() == null)
			employee.setSkills(new ArrayList<Skill>());
		if (!employee.getSkills().contains(skill)) {
			employee.getSkills().add(skill);
			return repository.save(employee);
		}
		return employee;
	}

	@Override
	public Employee addLanguage(Employee employee, EmployeeLanguage employeeLanguage) {
		if (employee.getLanguages() == null)
			employee.setLanguages(new ArrayList<EmployeeLanguage>());
		if (!employee.getLanguages().contains(employeeLanguage)) {
			employee.getLanguages().add(employeeLanguage);
			return repository.save(employee);
		}
		return employee;
	}

	@Override
	public Employee save(Employee entity) {
		List<EmployeeLanguage> employeeLanguages = entity.getLanguages();
		entity.setLanguages(null);
		Employee employee = super.save(entity);
		employeeLanguages = employeeLanguages.stream().map(el -> {
			return EmployeeLanguage
					.builder().employee(employee).language(el.getLanguage()).id(EmployeeLanguageKey.builder()
							.employeeId(employee.getId()).languageId(el.getLanguage().getId()).build())
					.level(el.getLevel()).build();
		}).collect(Collectors.toList());
		employeeLanguages = employeeLanguageService.saveAll(employeeLanguages);
		employee.setLanguages(employeeLanguages);
		return employee;
	}

	@Override
	public Employee edit(Long id, Employee newEntity) {
		Employee oldEmployee = super.edit(id, newEntity);
		oldEmployee.setBorn(newEntity.getBorn());
		oldEmployee.setPhone(newEntity.getPhone());
		return save(oldEmployee);
	}

	@Override
	public List<Employee> filter(Employee entity) {
		Example<UserDb> userDbExample = createUserDbExampleMatcher(entity);
		Employee employee = parseToEmployee(userDbExample.getProbe());
		return repository.findAll(Example.of(employee, userDbExample.getMatcher()));
	}

	@Override
	public List<Employee> filterEmployeeUsingKeywordsOrAge(EmployeeFilterRequest employee) {
		List<Employee> employees = filter(Employee.builder().email(employee.getEmail()).name(employee.getName())
				.status(employee.getStatus()).build());
		if(!employees.isEmpty()) {
			employees=employees.stream().filter(e -> {
				Integer age=LocalDateTime.now().getYear() - Util.getLocalDateTime(e.getBorn()).getYear();
				if(employee.getMinAge()!=null && age<employee.getMinAge())
					return false;
				if(employee.getMaxAge()!=null && age>employee.getMaxAge())
					return false;
				// TODO: keywords (experiences) and languages
				return true;
			}).toList();
			
		}
		return employees;
	}

}
