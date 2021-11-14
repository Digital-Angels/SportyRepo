package com.spring.sporty.service;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {
    public Commande add_commande(Commande c);
    public Optional<Commande> find_commande(long id);
    public void delete_commande(long id);
    public List<Commande> findAll();
    public List<Commande> advanced_searchcom(String pseudo);
}
