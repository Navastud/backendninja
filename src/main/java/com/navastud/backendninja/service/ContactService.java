package com.navastud.backendninja.service;

import java.util.List;

import com.navastud.backendninja.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);

	public abstract List<ContactModel> listAllContacts();
}
