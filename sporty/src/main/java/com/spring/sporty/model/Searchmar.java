package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Searchmar {
    private List<Marque> marques;
    private String pseudo;
}
