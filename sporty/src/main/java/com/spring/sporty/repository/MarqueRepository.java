package com.spring.sporty.repository;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Marque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarqueRepository extends CrudRepository<Marque,Long> {
    public List<Marque> findByNommarque(String m);
    @Query(value = "Select m from Marque m where m.nommarque Like :pseudo")
    public List<Marque> searchmar(@Param("pseudo") String pseudo);
}
