package com.spring.sporty.service;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Contact;
import com.spring.sporty.repository.CategorieRepository;
import com.spring.sporty.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository agent;

    @Override
    public Contact add_contact(Contact c) {
        return agent.save(c);
    }

    @Override
    public Optional<Contact> find_contact(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_contact(long id) {
        agent.deleteById(id);
    }

    @Override
    public Contact update_contact(Contact c) {
        return agent.save(c);
    }

    @Override
    public List<Contact> findAll() {
        return (List<Contact>) agent.findAll();
    }

    @Override
    public List<Contact> advanced_searchcon(String pseudo) {
        return agent.searchcon("%"+pseudo+"%");
    }
}
