package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String designation;
    private double prix;
    private int quantite;
    private String genre;
    @ManyToOne(optional = false)
    @JoinColumn(name="categorie_id", referencedColumnName = "id")
    private Categorie categorie;
    @ManyToOne(optional = false)
    @JoinColumn(name="marque_id", referencedColumnName = "id")
    private Marque marque;
    private  String image;

    public Produit() {
    }

    @Transient
    public String getPhotosImagePath() {
        if (image == null || id == null) return null;

        return "/user-photos/" + id + "/" + image;
    }
    public Produit(Long id, String designation, double prix, int quantite, String genre) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
        this.genre = genre;
    }
}
