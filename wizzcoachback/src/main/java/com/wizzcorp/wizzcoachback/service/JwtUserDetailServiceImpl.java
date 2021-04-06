package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.Account;
import com.wizzcorp.wizzcoachback.model.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountService accountService;


    @Override
    public  UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
       Account accountFromDb = accountService.findAccountByMail(mail);
        UserDetails userDetails = null;
        if( mail == null || !accountService.existsAccountByAdressMail(mail)){
            System.out.println("n'existe pas ");
            throw new UsernameNotFoundException(" utilisateur non trouvé");
        } else {
            userDetails = JwtUserFactory.create(accountFromDb);
            return  userDetails;
        }

    }
}
