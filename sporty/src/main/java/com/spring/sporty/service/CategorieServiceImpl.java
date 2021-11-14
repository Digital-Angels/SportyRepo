package com.spring.sporty.service;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    CategorieRepository agent;

    @Override
    public Categorie add_categorie(Categorie c) {
        return agent.save(c);
    }

    @Override
    public Optional<Categorie> find_categorie(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_categorie(long id) {
       agent.deleteById(id);
    }

    @Override
    public Categorie update_categorie(Categorie c) {
        return agent.save(c);
    }

    @Override
    public List<Categorie> findAll() {
        return (List<Categorie>) agent.findAll();
    }

    @Override
    public List<Categorie> advanced_searchcat(String pseudo) {
        return agent.searchcat("%"+pseudo+"%");
    }
}
