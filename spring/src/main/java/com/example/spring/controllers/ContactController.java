package com.example.spring.controllers;

import com.example.spring.models.Contact;
import com.example.spring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(method=RequestMethod.GET, value="/contacts")
    public Iterable<Contact> contact() {
        return contactRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/contacts")
    public Contact save(@RequestBody Contact contact) {
        contactRepository.save(contact);

        return contact;
    }

    @RequestMapping(method=RequestMethod.GET, value="/contacts/{id}")
    public Optional<Contact> show(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        return contactRepository.findById(userId);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/contacts/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Long userId = Long.parseLong(id);
        Optional<Contact> optional = contactRepository.findById(userId);
        Contact optionalContact = optional.get();
        if(contact.getName() != null)
            optionalContact.setName(contact.getName());
        if(contact.getAddress() != null)
            optionalContact.setAddress(contact.getAddress());
        if(contact.getCity() != null)
            optionalContact.setCity(contact.getCity());
        if(contact.getPhone() != null)
            optionalContact.setPhone(contact.getPhone());
        if(contact.getEmail() != null)
            optionalContact.setEmail(contact.getEmail());
        contactRepository.save(optionalContact);

        return optionalContact;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
    public String delete(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        Optional<Contact> optional = contactRepository.findById(userId);
        Contact optionalContact = optional.get();
        contactRepository.delete(optionalContact);

        return "";
    }
}