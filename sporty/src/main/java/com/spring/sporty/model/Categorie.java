package com.spring.sporty.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="categories")
public class Categorie {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String nomcat;

        @OneToMany(mappedBy = "categorie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
        private List<Produit> Produits;

        public Categorie() {
        }

        public Categorie(Long id, String nomcat) {
                this.id = id;
                this.nomcat = nomcat;
        }
}
