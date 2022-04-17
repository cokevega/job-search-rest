package com.jgvega.rest.jobsearch.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

public class Util {

	public static Date getDate(LocalDate date) {
		return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate getLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static <T> T getFromAnotherApi(String endpoint, Class<T> responseType) {
		RestTemplate template=new RestTemplate();
		T countries=template.getForObject(endpoint, responseType);
		return countries;
	}

}
