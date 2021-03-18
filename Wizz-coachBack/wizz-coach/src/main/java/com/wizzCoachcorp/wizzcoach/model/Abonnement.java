package com.wizzCoachcorp.wizzcoach.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public @Data
class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date inscription;
    Date finInscritpion;


    @ManyToOne @JoinColumn(name = "eleve_id")
    @JsonManagedReference(value = "findeleve")
    @JsonIgnore
    private User eleve;


    @ManyToOne @JoinColumn(name = "coach_id")
    @JsonManagedReference(value = "findcoach")
    @JsonIgnore
    private Coach coach;


    public Abonnement(Date inscription, Date finInscritpion, User user_id, Coach coach_id) {
        this.inscription = inscription;
        this.finInscritpion = finInscritpion;
        this.eleve = user_id;
        this.coach = coach_id;
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

    public User getEleve(User user_id) {
        return user_id;
    }

    public void setEleve(User user_id) {
        this.eleve = user_id;
    }

    public Coach getCoach(Coach coach_id) {
        return coach_id;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }


}
