package com.jgvega.rest.jobsearch.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

public class Util {

	/**
	 * Get Date from LocalDate
	 * 
	 * @param date LocalDate to transform into Date
	 * @return Date at the moment of date param
	 */
	public static Date getDate(LocalDateTime date) {
		return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Get LocalDate from Date.
	 * 
	 * @param date Date to transform into LocalDate
	 * @return LocalDate at the moment of date param
	 */
	public static LocalDateTime getLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * Get data from another Rest service.
	 * 
	 * @param <T>          Returned type, same as the service's response
	 * @param endpoint     The endpoint requested
	 * @param responseType Response type from the Rest service requested
	 * @return data from the Rest service
	 */
	public static <T> T getFromAnotherRest(String endpoint, Class<T> responseType) {
		RestTemplate template = new RestTemplate();
		T countries = template.getForObject(endpoint, responseType);
		return countries;
	}

}
