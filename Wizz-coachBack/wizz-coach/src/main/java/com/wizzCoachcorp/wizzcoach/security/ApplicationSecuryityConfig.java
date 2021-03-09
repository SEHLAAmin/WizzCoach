package com.wizzCoachcorp.wizzcoach.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.wizzCoachcorp.wizzcoach.security.ApplicationUserRole.*;
import static com.wizzCoachcorp.wizzcoach.security.ApplicationUserRole.ELEVE;

@Configuration
@EnableWebSecurity
public class ApplicationSecuryityConfig  extends WebSecurityConfigurerAdapter {



    private final PasswordEncoder passwordEncoder;
    @Autowired
   public  ApplicationSecuryityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }


    @Override /*Configure les accées */
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()  // wait
                .authorizeRequests()
                .antMatchers("/" ,"index" , "/css/*" ,"/js/").permitAll()
                .antMatchers("/api/**").hasRole(ELEVE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    /*Permet d'authentifer l'user dans la BDD et attribuer les rôle */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails cristanoUser= User.builder()
                .username("cristiano")
                .password(passwordEncoder.encode("password"))
                .roles(ELEVE.name()) // ROLE_STUDENT //ApplicatationUSerROLE.ELEVE.NAME()
                .build();

       UserDetails lindaUSer = User.builder()
               .username("RODRIGUEZ")
               .password(passwordEncoder.encode("password123"))
               .roles(COACH.name())
               .build();

        UserDetails tomUSer = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password456"))
                .roles(COACHSTAGIAIRE.name())  //ROLE_COACHSTAGIAIRE
                .build();

       return new InMemoryUserDetailsManager(
               cristanoUser,
               lindaUSer,
               tomUSer
       );
            }
}
