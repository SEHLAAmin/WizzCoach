package com.wizzcorp.wizzcoachback.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Data
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Date inscription;
    Date finInscritpion;

    @Column(name = "eleve_id")
    int eleveId;
    @Column(name = "coach_id")
    int coachId;

    @ManyToOne
    @JoinColumn(name = "eleve_id" , referencedColumnName = "id" , insertable = false , updatable = false)
    private User eleve;


    @ManyToOne
    @JoinColumn(name = "coach_id" , referencedColumnName = "id", insertable = false , updatable = false)
    @JsonIgnore
    private CoachUser coach;


    public Abonnement() {

    }
}
