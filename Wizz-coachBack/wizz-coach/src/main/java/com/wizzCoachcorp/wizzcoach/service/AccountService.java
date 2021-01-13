package com.wizzCoachcorp.wizzcoach.service;


import com.wizzCoachcorp.wizzcoach.model.Account;
import com.wizzCoachcorp.wizzcoach.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AccountService {
    Optional<Account> findById(Integer id);
    List<Account> findAll(String search);
    Account insert(Account account);
    Account update(Integer id, Account account);
    void delete(Integer id);

    @Service
    public class AccountServiceImpl implements AccountService {

        @Autowired
        private AccountRepository repository;

        @Override
        public Optional<Account> findById(Integer id) {
            return repository.findById(id);
        }

        @Override
        public List<Account> findAll(String search) {
            if (!"".equals(search))
                return repository.findByNameContaining(search);
            else
                return repository.findAll();
        }

        @Override
        public Account insert(Account account) {
            return repository.save(account);
        }

        @Override
        public Account update(Integer id, Account account) {
            Optional<Account> optionalAccount = this.findById(id);
            if (optionalAccount.isPresent()) {
                Account accountToUpdate = optionalAccount.get();
                accountToUpdate.setName(account.getName());
                if (account.getPseudo() != null)
                    accountToUpdate.setPseudo(account.getPseudo());
                if (account.getName() != null)
                    accountToUpdate.setName(account.getName());
                return repository.save(accountToUpdate);
            }
            return null;
        }

        @Override
        public void delete(Integer id) {
            Optional<Account> account = this.findById(id);
            if (account.isPresent()) {
                repository.delete(account.get());
            }
        }


    }}
