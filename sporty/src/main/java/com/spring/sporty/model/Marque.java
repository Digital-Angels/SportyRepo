package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="marques")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nommarque;
    @OneToMany(mappedBy = "marque",cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Produit> Produits;

}
