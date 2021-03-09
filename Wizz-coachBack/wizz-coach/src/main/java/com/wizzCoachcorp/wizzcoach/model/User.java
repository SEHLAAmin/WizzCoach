package com.wizzCoachcorp.wizzcoach.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends  Account {

    @Id
    int id;
    @ManyToMany
    private List<Coach> coachs;

    public void setCoach(Coach coachs) {
        this.coachs = (List<Coach>) coachs;
    }
}
