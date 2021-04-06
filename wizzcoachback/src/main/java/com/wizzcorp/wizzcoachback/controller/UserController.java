package com.wizzcorp.wizzcoachback.controller;


import com.wizzcorp.wizzcoachback.model.CoachUser;
import com.wizzcorp.wizzcoachback.model.User;
import com.wizzcorp.wizzcoachback.repository.UserRepository;
import com.wizzcorp.wizzcoachback.service.AbonnementService;
import com.wizzcorp.wizzcoachback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AbonnementService abonnementService;

    @GetMapping
    ResponseEntity<List<User>> getUtilisateurs() {
        List<User> listUser= userService.userList();

        return ResponseEntity.ok(
                listUser
        );
    }



    @PostMapping(value = "/createUser")
    ResponseEntity<User> postUser(@RequestBody User user) {


        return ResponseEntity.ok(
                userService.saveUser(user)
        );
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @RequestMapping(value ="" , method = RequestMethod.GET , params = {"coach_id"})
    ResponseEntity<List<User>> getAllElevesByCoachId(
            @RequestParam(name = "coach_id") int coachId
    ) {

        return ResponseEntity.ok(
                abonnementService.findELevesByCoachUserId(coachId)
        );
    }

}
