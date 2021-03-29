package com.wizzCoachcorp.wizzcoach.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Categorie {

    @Id
    int id;
    String libelle;

    @ManyToOne
    @JsonIgnore
    Live lives;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Live getLives() {
        return lives;
    }

    public void setLives(Live lives) {
        this.lives = lives;
    }
}
