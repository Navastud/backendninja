package com.navastud.backendninja.service;

import java.util.List;

import com.navastud.backendninja.entity.Contact;
import com.navastud.backendninja.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ContactService {

	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact model
	 */
	public abstract ContactModel addContact(ContactModel contactModel);

	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	public abstract List<ContactModel> listAllContacts();

	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	public abstract Contact findContactById(int id);

	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	public abstract void removeContact(int id);

	/**
	 * Find contact by id model.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	public abstract ContactModel findContactByIdModel(int id);
}
