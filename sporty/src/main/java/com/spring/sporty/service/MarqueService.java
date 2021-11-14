package com.spring.sporty.service;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Marque;

import java.util.List;
import java.util.Optional;

public interface MarqueService {
    public Marque add_marque(Marque m);
    public Optional<Marque> find_marque(long id);
    public void delete_marque(long id);
    public Marque update_marque(Marque m);
    public List<Marque> findAll();
    public List<Marque> advanced_searchmar(String pseudo);

}
