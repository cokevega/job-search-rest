package com.jgvega.rest.jobsearch.service;

import java.util.List;

import com.jgvega.rest.jobsearch.entity.Education;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.Experience;
import com.jgvega.rest.jobsearch.entity.Skill;
import com.jgvega.rest.jobsearch.model.request.EmployeeFilterRequest;

public interface IEmployeeService extends IUserDbService<Employee, Long> {

	public Employee addEducation(Employee employee, Education education);

	public Employee addExperience(Employee employee, Experience experience);

	public Employee addSkill(Employee employee, Skill skill);

	public Employee addLanguage(Employee employee, EmployeeLanguage employeeLanguage);
	
	public List<Employee> filterEmployeeUsingKeywordsOrAge(EmployeeFilterRequest employee);

}
