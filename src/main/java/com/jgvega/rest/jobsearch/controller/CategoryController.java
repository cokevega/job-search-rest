package com.jgvega.rest.jobsearch.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.service.ICategoryService;

@RestController
@RequestMapping("/category")
@Profile("rest")
public class CategoryController extends CommonController<Category, Long, ICategoryService> {

}
