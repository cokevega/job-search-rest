package com.jgvega.rest.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgvega.rest.jobsearch.model.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
