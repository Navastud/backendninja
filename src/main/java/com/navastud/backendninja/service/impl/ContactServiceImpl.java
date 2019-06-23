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

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts.stream().map(contact -> contactConverter.convertContact2ContactModel(contact))
				.collect(Collectors.toList());
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);

		if (null != contact)
			contactRepository.delete(contact);
	}

}
