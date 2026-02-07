package com.example.contactmanager.service;

import java.util.List;

import com.example.contactmanager.model.Contact;

public interface ContactService {
	
	List<Contact> getAllContacts();
	void saveContact(Contact contact);
	void deleteContact(int id);
	Contact getContactById(int id);
}
