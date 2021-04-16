package com.wizzcorp.wizzcoachback.registration;


import lombok.*;


// modéle de la requête en gros
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {


   private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;



}
