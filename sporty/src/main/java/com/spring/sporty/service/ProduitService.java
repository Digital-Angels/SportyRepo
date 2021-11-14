package com.spring.sporty.service;

import com.spring.sporty.model.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    public Produit add_produit(Produit d);
    public Optional<Produit> find_produit(long id);
    public void delete_produit(long id);
    public  Produit update_produit(Produit d);
    public List<Produit> findAll();
    public List<Produit> advanced_search(String pseudo);
  //  public  List<Produit>search_categorie(String categorie);
  //  public  List<Produit>advanced_search(String categorie,String pseudo);
}
