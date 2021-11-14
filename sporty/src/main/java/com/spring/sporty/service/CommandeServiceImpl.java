package com.spring.sporty.service;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Commande;
import com.spring.sporty.repository.CategorieRepository;
import com.spring.sporty.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService{
    @Autowired
    CommandeRepository agent;

    @Override
    public Commande add_commande(Commande c) {
        return agent.save(c);
    }

    @Override
    public Optional<Commande> find_commande(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_commande(long id) {
        agent.deleteById(id);
    }

    @Override
    public List<Commande> findAll() {
        return (List<Commande>) agent.findAll();
    }

    @Override
    public List<Commande> advanced_searchcom(String pseudo) {
        return agent.searchcom("%"+pseudo+"%");
    }
}
