package com.spring.sporty.service;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    public Contact add_contact(Contact c);
    public Optional<Contact> find_contact(long id);
    public void delete_contact(long id);
    public  Contact update_contact(Contact c);
    public List<Contact> findAll();
    public List<Contact> advanced_searchcon(String pseudo);
}
