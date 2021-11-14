package com.spring.sporty.service;

import com.spring.sporty.model.Produit;
import com.spring.sporty.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository agent;
    @Override
    public Produit add_produit(Produit d) {
        return agent.save(d);
    }

    @Override
    public Optional<Produit> find_produit(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_produit(long id) {
        agent.deleteById(id);
    }

    @Override
    public Produit update_produit(Produit d) {
        return agent.save(d);
    }

    @Override
    public List<Produit> findAll() {
        return (List<Produit>) agent.findAll();
    }

    @Override
    public List<Produit> advanced_search(String pseudo) {
        return agent.search("%"+pseudo+"%");
    }

}
