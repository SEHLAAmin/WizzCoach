package com.wizzcorp.wizzcoachback.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;


    // enregistre un nouvelle utilisateur en faisant apelle aux registrationService
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {

        return registrationService.register(request);

    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
