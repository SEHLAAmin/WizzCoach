package com.wizzcorp.wizzcoachback.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Live {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    public String title;
    public  String description;
    public String urlLive;
    public Date heureDuLive;
    int duree;
    boolean streamEnd;
    boolean isAvailable;


    @ManyToOne
    @JoinColumn(name="auteur_id")
    @JsonIgnore
    CoachUser auteur;


    @OneToMany(mappedBy = "lives")
    @JsonIgnore
    List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public CoachUser getAuteur() {
        return auteur;
    }

    public void setAuteur(CoachUser auteur) {
        this.auteur = auteur;
    }

    public String getUrlLive() {
        return urlLive;
    }

    public void setUrlLive(String urlLive) {
        this.urlLive = urlLive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getHeureDuLive() {
        return heureDuLive;
    }

    public void setHeureDuLive(Date heureDuLive) {
        this.heureDuLive = heureDuLive;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isStreamEnd() {
        return streamEnd;
    }

    public void setStreamEnd(boolean streamEnd) {
        this.streamEnd = streamEnd;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
