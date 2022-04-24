package com.jgvega.rest.jobsearch.service.impl;

import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.CommonService;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.repository.ICategoryRepository;
import com.jgvega.rest.jobsearch.service.ICategoryService;

@Service
public class CategoryService extends CommonService<Category, Long, ICategoryRepository> implements ICategoryService {

}
