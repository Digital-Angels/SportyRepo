package com.spring.sporty.repository;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    public List<Contact> findByName(String n);
    @Query(value = "Select m from Contact m where m.name Like :pseudo or m.subject Like :pseudo")
    public List<Contact> searchcon(@Param("pseudo") String pseudo);
}
