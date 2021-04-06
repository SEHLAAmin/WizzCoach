package com.wizzcorp.wizzcoachback.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    String adressMail;
    String role;
    boolean enabled;

}
