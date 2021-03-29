package com.wizzCoachcorp.wizzcoach.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Data
public class Coach extends Account {
    @Id
    int id;


    @OneToMany(mappedBy = "coach")
    @JsonBackReference(value = "findeleve")
    @JsonIgnore
    List<Abonnement> abonnements;

    @OneToMany(mappedBy = "auteur")
    @JsonManagedReference
    List<Live> liveList;

    public List<Live> getLiveList() {
        return liveList;
    }

    public void setLiveList(List<Live> liveList) {
        this.liveList = liveList;
    }

    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public int getId(int coach_id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
