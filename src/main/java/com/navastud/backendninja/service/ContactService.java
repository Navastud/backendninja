package com.navastud.backendninja.service;

import java.util.List;

import com.navastud.backendninja.entity.Contact;
import com.navastud.backendninja.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);

	public abstract List<ContactModel> listAllContacts();

	public abstract Contact findContactById(int id);

	public abstract void removeContact(int id);

	public abstract ContactModel findContactByIdModel(int id);
}
