package com.wizzCoachcorp.wizzcoach.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public @Data
class Abonnement {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    Date inscription;
    Date finInscritpion;


    @ManyToOne
    @JsonManagedReference(value = "findeleve")
    @JsonIgnore
    private User eleve;


    @ManyToOne
    @JsonManagedReference( value = "findcoach")
    @JsonIgnore
    private Coach coach;


    public Abonnement(Date inscription, Date finInscritpion, User eleve, Coach coach) {
        this.inscription = inscription;
        this.finInscritpion = finInscritpion;
        this.eleve = eleve;
        this.coach = coach;
    }

    public Abonnement() {

    }

    public Date getInscription() {
        return inscription;
    }

    public void setInscription(Date inscription) {
        this.inscription = inscription;
    }

    public Date getFinInscritpion() {
        return finInscritpion;
    }

    public void setFinInscritpion(Date finInscritpion) {
        this.finInscritpion = finInscritpion;
    }

    public User getEleve() {
        return eleve;
    }

    public void setEleve(User eleve) {
        this.eleve = eleve;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
