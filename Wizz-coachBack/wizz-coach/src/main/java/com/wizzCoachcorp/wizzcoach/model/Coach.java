package com.wizzCoachcorp.wizzcoach.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.wizzCoachcorp.wizzcoach.model.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Data
public class Coach extends Account {
    @Id
    int id;


    @OneToMany(mappedBy = "eleve")
    @JsonBackReference(value = "findeleve")
    @JsonIgnore
    List<Abonnement> listAbonnes;

    public List<Abonnement> getListAbonnes() {
        return listAbonnes;
    }

    public void setListAbonnes(List<Abonnement> listAbonnes) {
        this.listAbonnes = listAbonnes;
    }

    public int getId(int coach_id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
