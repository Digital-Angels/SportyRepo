package com.spring.sporty.service;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Commande;
import com.spring.sporty.model.Produit;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    public Categorie add_categorie(Categorie c);
    public Optional<Categorie> find_categorie(long id);
    public void delete_categorie(long id);
    public  Categorie update_categorie(Categorie c);
    public List<Categorie> findAll();
    public List<Categorie> advanced_searchcat(String pseudo);

}
