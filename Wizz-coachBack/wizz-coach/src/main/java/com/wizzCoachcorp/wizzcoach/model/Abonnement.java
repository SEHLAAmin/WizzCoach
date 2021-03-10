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
    int id;
    Date inscription;
    Date finInscritpion;


    @ManyToOne
    @JsonManagedReference(value = "findeleve")
    @JsonIgnore
    private User eleve;


    @ManyToOne
    @JsonManagedReference(value = "findcoach")
    @JsonIgnore
    private Coach coach;

}
