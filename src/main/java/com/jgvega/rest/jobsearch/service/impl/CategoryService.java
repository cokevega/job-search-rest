package com.jgvega.rest.jobsearch.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.jgvega.rest.jobsearch.commons.service.impl.CommonService;
import com.jgvega.rest.jobsearch.entity.Category;
import com.jgvega.rest.jobsearch.repository.ICategoryRepository;
import com.jgvega.rest.jobsearch.service.ICategoryService;

@Service
public class CategoryService extends CommonService<Category, Long, ICategoryRepository>
		implements ICategoryService {

	@Override
	public Category edit(Long id, Category newEntity) {
		Category oldEntity = super.edit(id, newEntity);
		oldEntity.setName(newEntity.getName());
		oldEntity.setDescription(newEntity.getDescription());
		return save(oldEntity);
	}

	@Override
	public List<Category> filter(Category entity) {
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase();
		Category category=Category.builder().build();
		if (entity.getName() != null) {
			exampleMatcher = exampleMatcher.withMatcher("name", GenericPropertyMatchers.contains());
			category.setName(entity.getName());
		}
		if (entity.getDescription() != null) {
			exampleMatcher = exampleMatcher.withMatcher("description", GenericPropertyMatchers.contains());
			category.setDescription(entity.getDescription());
		}
		return findByExample(Example.of(category, exampleMatcher));
	}

}
