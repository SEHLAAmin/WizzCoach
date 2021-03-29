package com.wizzCoachcorp.wizzcoach.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;


@Entity
public class Live {

    @Id
 int id;
 public String title;
 public  String descritpions;
 public String URLLive;
  public Date heureDulLive;
  int duree;
  boolean streamEnd;

  @ManyToOne@JoinColumn(name="auteur_id")
  Coach auteur;

@OneToMany(mappedBy = "lives")
List<Categorie> categorieList;

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
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

    public String getDescritpions() {
        return descritpions;
    }

    public void setDescritpions(String descritpions) {
        this.descritpions = descritpions;
    }

    public String getURLLive() {
        return URLLive;
    }

    public void setURLLive(String URLLive) {
        this.URLLive = URLLive;
    }

    public Date getHeureDulLive() {
        return heureDulLive;
    }

    public void setHeureDulLive(Date heureDulLive) {
        this.heureDulLive = heureDulLive;
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

    public Coach getAuteur(Coach id) {
        return auteur;
    }

    public void setAuteur(Coach auteur) {
        this.auteur = auteur;
    }
}
