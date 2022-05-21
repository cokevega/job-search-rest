package com.jgvega.rest.jobsearch.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.entity.Employee;
import com.jgvega.rest.jobsearch.service.IEmployeeService;

@RestController
@Profile("rest")
@RequestMapping("/employee")
public class EmployeeController extends CommonController<Employee, Long, IEmployeeService> {

}
