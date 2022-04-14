package com.jgvega.rest.jobsearch.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.model.entity.Education;
import com.jgvega.rest.jobsearch.model.entity.Employee;
import com.jgvega.rest.jobsearch.model.entity.Experience;
import com.jgvega.rest.jobsearch.model.entity.Skill;
import com.jgvega.rest.jobsearch.repository.IEmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	public Employee addEducation(Employee employee, Education education) {
		if (employee.getEducation() == null)
			employee.setEducation(new ArrayList<Education>());
		if (!employee.getEducation().contains(education)) {
			employee.getEducation().add(education);
			return employeeRepository.save(employee);
		}
		return employee;
	}

	public Employee addExperience(Employee employee, Experience experience) {
		if (employee.getExperiences() == null)
			employee.setExperiences(new ArrayList<Experience>());
		if (!employee.getExperiences().contains(experience)) {
			employee.getExperiences().add(experience);
			return employeeRepository.save(employee);
		}
		return employee;
	}

	public Employee addSkill(Employee employee, Skill skill) {
		if (employee.getSkills() == null)
			employee.setSkills(new ArrayList<Skill>());
		if (!employee.getSkills().contains(skill)) {
			employee.getSkills().add(skill);
			return employeeRepository.save(employee);
		}
		return employee;
	}

}
