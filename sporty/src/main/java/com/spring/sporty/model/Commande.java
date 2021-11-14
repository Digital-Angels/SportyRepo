package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@NoArgsConstructor

@Entity
@Table(name="commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantite;
    private String reference;
    private String nomclient;
    private String prenomclient;
    private String adresseclient;
    private int telclient;

    public Commande() {
    }

    public Commande(Long id, int quantite, String reference, String nomclient, String prenomclient, String adresseclient, int telclient) {
        this.id = id;
        this.quantite = quantite;
        this.reference = reference;
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.adresseclient = adresseclient;
        this.telclient = telclient;
    }
}
