package com.jgvega.rest.jobsearch.commons.faker;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;

import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CommonFaker<E> implements CommandLineRunner {

	/**
	 * Faker instance to create fake data Spanish // UK English // American English
	 */
//	protected final Faker faker = Faker.instance(
//			Locale.lookup(LanguageRange.parse("es-Es,en-UK,en-US"), Arrays.asList(Locale.getAvailableLocales())));

	/**
	 * Faker instance to create fake data English
	 */
	protected final Faker faker = Faker.instance();

	/**
	 * Collection which will be persisted.
	 */
	protected Collection<E> fakeEntities;

	/**
	 * This Faker's process initialization.
	 */
	protected abstract void init();

	/**
	 * Create a fake instance of the specified E entity.
	 * 
	 * @param i Counter
	 */
	protected abstract void createFakeEntity(long i);

	/**
	 * Return true if the entity is not present at the fakeEntities field. hashCode
	 * and equals implementation are required.
	 * 
	 * @param entity The entity to evaluate
	 * @return true if it is not present
	 */
	protected boolean validateCreatedEntity(E entity) {
		return !fakeEntities.contains(entity);
	}

	/**
	 * Finish the application by calling the <b><i>System.exit</i></b> method.
	 * 
	 * @param exit exit status
	 */
	protected void finishFakers(int exit) {
		log.info("Finished fake data creation");
		System.exit(exit);
	}

}
