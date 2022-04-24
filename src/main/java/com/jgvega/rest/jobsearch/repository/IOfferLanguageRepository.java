package com.jgvega.rest.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgvega.rest.jobsearch.model.entity.OfferLanguage;
import com.jgvega.rest.jobsearch.model.entity.key.OfferLanguageKey;

@Repository
public interface IOfferLanguageRepository extends JpaRepository<OfferLanguage, OfferLanguageKey> {

}
