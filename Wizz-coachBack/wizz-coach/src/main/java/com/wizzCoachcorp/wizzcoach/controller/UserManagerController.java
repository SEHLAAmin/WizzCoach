package com.wizzCoachcorp.wizzcoach.controller;


import com.wizzCoachcorp.wizzcoach.model.Account;
import com.wizzCoachcorp.wizzcoach.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "management/api/v1/eleve")
public class UserManagerController {

private final List<User> ELEVE = Arrays.asList(
);


// GET
    @GetMapping
public List<User> getAllStudents (@RequestBody  User eleve) {
    return ELEVE;
}

// POST
    @PostMapping
public void registerNewStudent(@RequestBody  User eleveId){
    System.out.println(eleveId);
}
// PUT
    @PutMapping(path = "{eleveId}")
public void updateStudent(@PathVariable("eleveId") Integer eleveId , User eleve){

    System.out.println(String.format("%s %s" , eleveId , eleve));
}


//DELETE
    @DeleteMapping(path = "{eleveId}")
public void deleteStudent (@PathVariable("eleveId") Integer eleveId){

    System.out.println(eleveId);
}
}