package com.navastud.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.navastud.backendninja.model.Person;
import com.navastud.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleService.class);

	@Override
	public List<Person> getListPeople() {

		List<Person> people = new ArrayList<Person>();
		people.add(new Person("David", 25));
		people.add(new Person("Anibal", 26));
		people.add(new Person("Sebastian", 23));
		people.add(new Person("Jorge", 28));
		people.add(new Person("Nicolas", 27));

		LOG.info("HELLO FROM SERVICE");

		return people;
	}

}
