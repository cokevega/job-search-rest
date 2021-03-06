package com.jgvega.rest.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgvega.rest.jobsearch.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
