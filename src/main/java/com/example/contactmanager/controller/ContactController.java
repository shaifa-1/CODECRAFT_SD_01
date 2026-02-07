package com.example.contactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.service.ContactService;

@Controller
public class ContactController {
    
	private final ContactService service;
	
	public ContactController(ContactService service) {
		this.service=service;
	}
	  @GetMapping("/")
      public String viewContacts(Model model) {
    	model.addAttribute("contacts",service.getAllContacts());
		return "index";
		}
	  
	  @GetMapping("/add")
      public String addContactForm(Model model) {
    	model.addAttribute("contact",new Contact());
		return "add";
		}
	
      @PostMapping("/save")
      public String saveContact(@ModelAttribute Contact contact) {
		 service.saveContact(contact);
		return "redirect:/";
		}
      
      @GetMapping("/delete/{id}")
      public String deleteContact(@PathVariable int id) {
		service.deleteContact(id); 
    	return "redirect:/";
		}
      @GetMapping("/edit/{id}")
      public String editContact(@PathVariable int id,Model model) {
		  Contact contact=service.getContactById(id);
		  model.addAttribute("contact", contact);
    	  return "add";
		
	}
          
}
