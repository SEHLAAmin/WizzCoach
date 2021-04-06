package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.Account;
import com.wizzcorp.wizzcoachback.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
    private AccountRepository accountRepo;

    @Override
    public void saveAccount(Account account) {
        accountRepo.save(account);
    }


   @Override
    public Account findAccountByMail(String mail) {
        return null ; /* accountRepo.findAccountByAdressMail(mail); */
    }

    @Override
    public boolean existsAccountByAdressMail(String mail) {
        return false; /*accountRepo.existsAccountByAdressMail(mail);*/
    }
}
