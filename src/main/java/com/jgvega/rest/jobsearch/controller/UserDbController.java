package com.jgvega.rest.jobsearch.controller;

import com.jgvega.rest.jobsearch.commons.controller.CommonController;
import com.jgvega.rest.jobsearch.commons.entity.UserDb;
import com.jgvega.rest.jobsearch.service.IUserDbService;

public class UserDbController<E extends UserDb, I, S extends IUserDbService<E, I>> extends CommonController<E, I, S> {

}
