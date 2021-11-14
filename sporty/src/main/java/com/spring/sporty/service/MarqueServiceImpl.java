package com.spring.sporty.service;

import com.spring.sporty.model.Marque;
import com.spring.sporty.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueServiceImpl implements MarqueService{
    @Autowired
    MarqueRepository agent;
    @Override

    public Marque add_marque(Marque m) {
        return agent.save(m);
    }

    @Override
    public Optional<Marque> find_marque(long id) {
        return agent.findById(id);
    }

    @Override
    public void delete_marque(long id) {
        agent.deleteById(id);

    }

    @Override
    public Marque update_marque(Marque m) {
        return agent.save(m);
    }

    @Override
    public List<Marque> findAll() {
        return (List<Marque>) agent.findAll();
    }

    @Override
    public List<Marque> advanced_searchmar(String pseudo) {
        return agent.searchmar("%"+pseudo+"%");
    }
}
