package com.wizzcorp.wizzcoachback.config;

import com.wizzcorp.wizzcoachback.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /*  @Autowired
    JwtAuthEntryPoint jwtAuthEntryPoint; */
        private final AppUserService appUserService;
        private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//configuration des accés aux URI
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v*/registration/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    // fournis les info d'authentification SPS et lui dit ou chercher
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider () {

        //créer le fournisseur SPS
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //set l'encodage qu'il doit comprendre
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        // dit a SPS ou sont les userdetailsService
        provider.setUserDetailsService(appUserService);

        return provider;
    }
}
