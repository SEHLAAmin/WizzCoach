package com.wizzCoachcorp.wizzcoach.controller;

import com.wizzCoachcorp.wizzcoach.model.Account;
import com.wizzCoachcorp.wizzcoach.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.wizzCoachcorp.wizzcoach.service.AccountService;

@RestController
@RequestMapping("/wizzcoach")
public class AccountController {
    @Autowired
    AccountService service;


    @CrossOrigin
    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAllAccount(@RequestParam(value="search", defaultValue="") String search) {
        List<Account> listAccount;
        try {
            listAccount = service.findAll(search);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listAccount);
    }
    @CrossOrigin
    @GetMapping("/account/{id}")
    ResponseEntity<Account> getAccountById(@PathVariable(value="id") int id) {
        Optional<Account> account = service.findById(id);
        if (account.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(account.get());
    }
    @CrossOrigin
    @PostMapping("/account")
    ResponseEntity<Account> addAccount(@RequestBody Account account){
        return ResponseEntity.ok().body(service.insert(account));
    }
    @CrossOrigin
    @PutMapping("/account/{id}")
    ResponseEntity<Account> updateAccount(@PathVariable(value="id") int id, @RequestBody Account account){
        Account updatedAccount = service.update(id, account);
        if(updatedAccount == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(updatedAccount);
    }
    @CrossOrigin
    @DeleteMapping("/account/{id}")
    ResponseEntity<Account> deleteAccount(@PathVariable(value="id") int id){
        Optional<Account> account = service.findById(id);
        if(account.isEmpty())
            return ResponseEntity.notFound().build();
        service.delete(account.get().getId());
        return ResponseEntity.accepted().build();
    }


}
