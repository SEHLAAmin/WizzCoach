package com.wizzCoachcorp.wizzcoach.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Data
public class User extends  Account {

    @Id
    int id;


    @OneToMany(mappedBy = "coach")
    @JsonBackReference(value = "findcoach")
            @JsonIgnore
    List<Abonnement> listCoachs;

    public List<Abonnement> getListCoachs() {
        return listCoachs;
    }

    public void setListCoachs(List<Abonnement> listCoachs) {
        this.listCoachs = listCoachs;
    }
}
