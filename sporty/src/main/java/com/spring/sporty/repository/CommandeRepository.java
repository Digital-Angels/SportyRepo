package com.spring.sporty.repository;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Commande;
import com.spring.sporty.model.Marque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeRepository extends CrudRepository<Commande, Long> {
    public List<Commande> findByNomclient(String m);
    @Query(value = "Select m from Commande m where m.nomclient Like :pseudo or m.prenomclient Like :pseudo or m.reference Like :pseudo")
    public List<Commande> searchcom(@Param("pseudo") String pseudo);
}
