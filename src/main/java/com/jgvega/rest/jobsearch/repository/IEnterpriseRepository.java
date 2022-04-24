package com.jgvega.rest.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgvega.rest.jobsearch.entity.Enterprise;

@Repository
public interface IEnterpriseRepository extends JpaRepository<Enterprise, Long> {

}
