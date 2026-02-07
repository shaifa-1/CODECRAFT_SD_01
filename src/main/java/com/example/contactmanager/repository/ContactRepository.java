package com.example.contactmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contactmanager.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
 
}
 