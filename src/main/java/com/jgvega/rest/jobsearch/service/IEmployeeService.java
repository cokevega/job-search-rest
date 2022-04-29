package com.jgvega.rest.jobsearch.service;

import com.jgvega.rest.jobsearch.commons.service.ICommonService;
import com.jgvega.rest.jobsearch.entity.Education;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.Experience;
import com.jgvega.rest.jobsearch.entity.Skill;

public interface IEmployeeService extends ICommonService<Employee, Long> {

	public Employee addEducation(Employee employee, Education education);

	public Employee addExperience(Employee employee, Experience experience);

	public Employee addSkill(Employee employee, Skill skill);

	public Employee addLanguage(Employee employee, EmployeeLanguage employeeLanguage);

}
