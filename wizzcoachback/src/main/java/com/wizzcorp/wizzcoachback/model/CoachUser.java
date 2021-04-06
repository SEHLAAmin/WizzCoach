package com.wizzcorp.wizzcoachback.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class CoachUser extends Account{

    @OneToMany(mappedBy = "auteur")
    @JsonManagedReference
             @JsonIgnore
    List<Live> liveList;

    public List<Live> getLiveList() {
        return liveList;
    }

    public void setLiveList(List<Live> liveList) {
        this.liveList = liveList;
    }
}
