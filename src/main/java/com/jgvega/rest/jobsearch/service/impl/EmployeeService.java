package com.jgvega.rest.jobsearch.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Education;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.Experience;
import com.jgvega.rest.jobsearch.entity.Skill;
import com.jgvega.rest.jobsearch.repository.IEmployeeRepository;
import com.jgvega.rest.jobsearch.service.IEmployeeService;

@Service
public class EmployeeService extends CommonService<Employee, Long, IEmployeeRepository> implements IEmployeeService {

	public Employee addEducation(Employee employee, Education education) {
		if (employee.getEducation() == null)
			employee.setEducation(new ArrayList<Education>());
		if (!employee.getEducation().contains(education)) {
			employee.getEducation().add(education);
			return repository.save(employee);
		}
		return employee;
	}

	public Employee addExperience(Employee employee, Experience experience) {
		if (employee.getExperiences() == null)
			employee.setExperiences(new ArrayList<Experience>());
		if (!employee.getExperiences().contains(experience)) {
			employee.getExperiences().add(experience);
			return repository.save(employee);
		}
		return employee;
	}

	public Employee addSkill(Employee employee, Skill skill) {
		if (employee.getSkills() == null)
			employee.setSkills(new ArrayList<Skill>());
		if (!employee.getSkills().contains(skill)) {
			employee.getSkills().add(skill);
			return repository.save(employee);
		}
		return employee;
	}

	public Employee addLanguage(Employee employee, EmployeeLanguage employeeLanguage) {
		if (employee.getLanguages() == null)
			employee.setLanguages(new ArrayList<EmployeeLanguage>());
		if (!employee.getLanguages().contains(employeeLanguage)) {
			employee.getLanguages().add(employeeLanguage);
			return repository.save(employee);
		}
		return employee;
	}

}
