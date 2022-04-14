package com.jgvega.rest.jobsearch.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.model.entity.Education;
import com.jgvega.rest.jobsearch.model.entity.Employee;
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

}
