package com.wizzcorp.wizzcoachback.controller;

import com.wizzcorp.wizzcoachback.model.Account;
import com.wizzcorp.wizzcoachback.repository.AccountRepository;
import com.wizzcorp.wizzcoachback.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/account")
@CrossOrigin
public class AccountController {
@Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public String postAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return "OK";
    }


    @PutMapping
    public ResponseEntity<Void> modifyAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
