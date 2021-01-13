package com.wizzCoachcorp.wizzcoach.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;


@Entity

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String name;
    String lastName;
    String password;
    String pseudo;
    String adressMail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAdressMail() {
        return adressMail;
    }

    public void setAdressMail(String adressMail) {
        this.adressMail = adressMail;
    }
}
