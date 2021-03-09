package com.wizzCoachcorp.wizzcoach.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Coach extends Account {
    @Id
    int id;

    @ManyToMany(mappedBy = "coachs")
    private List<User> eleves;

    public void setEleves(List<User> eleves) {
        this.eleves = eleves;
    }
}
