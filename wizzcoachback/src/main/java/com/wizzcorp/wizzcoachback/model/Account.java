package com.wizzcorp.wizzcoachback.model;


import lombok.Data;
import javax.persistence.*;

@MappedSuperclass
@Data
public class Account {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String userName;
    String lastName;
    String pseudo;
    String password;
    String email;
    String role;
    boolean enabled;

}
