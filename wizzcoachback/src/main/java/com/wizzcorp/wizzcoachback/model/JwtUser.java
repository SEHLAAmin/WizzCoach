package com.wizzcorp.wizzcoachback.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails {
    private int id;
    private String username;
    private String password;
    private Account account;
    private boolean enabled;
    private Collection<? extends  GrantedAuthority> grantedAuthorities;

    public JwtUser(int id , String username , String password , Account account , boolean enabled , Collection<? extends  GrantedAuthority> grantedAuthorities ) {
        this.id = id;
        this.username = username;
        this.password = password ;
        this.account = account;
        this.enabled = enabled;
        this.grantedAuthorities = grantedAuthorities;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
