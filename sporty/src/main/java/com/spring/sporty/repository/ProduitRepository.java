package com.spring.sporty.repository;

import com.spring.sporty.model.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit,Long> {
    @Query(value = "Select m from Produit m where m.designation Like :pseudo or m.genre Like :pseudo or m.categorie.nomcat Like :pseudo or m.marque.nommarque Like :pseudo")
    public List<Produit> search(@Param("pseudo") String pseudo);
}
