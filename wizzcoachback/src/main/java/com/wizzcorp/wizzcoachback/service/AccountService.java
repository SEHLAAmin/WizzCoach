package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.Account;

public interface AccountService {
  void saveAccount(Account account);
    Account findAccountByMail(String mail);
    boolean existsAccountByAdressMail(String mail);
}
