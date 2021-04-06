package com.wizzcorp.wizzcoachback.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public static JwtUser create(Account account) {
        return new JwtUser(account.getId()  , account.getUserName() , account.getPassword() , account , account.isEnabled() , maptoGrantedAuthorities(new ArrayList<>(Arrays.asList("ROLE_" + account.getRole() ))) );
    }
    public static List<GrantedAuthority> maptoGrantedAuthorities(List<String> autorities){
        return autorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
    }
}
