package com.jgvega.rest.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgvega.rest.jobsearch.entity.EmployeeLanguage;
import com.jgvega.rest.jobsearch.entity.key.EmployeeLanguageKey;

@Repository
public interface IEmployeeLanguageRepository extends JpaRepository<EmployeeLanguage, EmployeeLanguageKey> {

}
