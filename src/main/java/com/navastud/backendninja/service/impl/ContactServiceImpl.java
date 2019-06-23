package com.navastud.backendninja.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.navastud.backendninja.component.ContactConverter;
import com.navastud.backendninja.entity.Contact;
import com.navastud.backendninja.model.ContactModel;
import com.navastud.backendninja.repository.ContactRepository;
import com.navastud.backendninja.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	/** The contact repository. */
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	/** The contact converter. */
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact model
	 */
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts.stream().map(contact -> contactConverter.convertContact2ContactModel(contact))
				.collect(Collectors.toList());
	}

	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	/**
	 * Find contact by id model.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}

	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);

		if (null != contact)
			contactRepository.delete(contact);
	}

}
