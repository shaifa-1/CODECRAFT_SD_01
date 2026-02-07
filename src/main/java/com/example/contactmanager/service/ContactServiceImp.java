package com.example.contactmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactService{
    
	private final ContactRepository repo;
	
	public ContactServiceImp(ContactRepository repo) {
		this.repo=repo;
	}
	
	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public void saveContact(Contact contact) {
	    repo.save(contact);
	}

	@Override
	public void deleteContact(int id) {
		repo.deleteById(id);
	}

	@Override
	public Contact getContactById(int id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("Contact not found"));
	}

}
