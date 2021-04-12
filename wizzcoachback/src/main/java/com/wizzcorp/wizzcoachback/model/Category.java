package com.wizzcorp.wizzcoachback.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    long id;
    String libelles;

    @ManyToOne
    Live lives;


    public Live getLives() {
        return lives;
    }

    public void setLives(Live lives) {
        this.lives = lives;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelles() {
        return libelles;
    }

    public void setLibelles(String libelles) {
        this.libelles = libelles;
    }
}
