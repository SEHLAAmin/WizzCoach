package com.wizzcorp.wizzcoachback.appuser;

import com.wizzcorp.wizzcoachback.registration.token.ConfirmationToken;
import com.wizzcorp.wizzcoachback.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {


    private final static  String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AppUserRepository appUserRepository;
    //permet d'encoder les mdp
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow( () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));

    }
    public String signUpUser(AppUser appUser){
        //verifie si l'adresse est deja prise
      boolean userExist =  appUserRepository.findByEmail(appUser.getEmail())
               .isPresent();
       if(userExist) {
           throw new IllegalStateException("email already exist");
       }
       //
        //
        // apelle la fonction d'encodage qui se trouve dans la classe Bcrypt qui est propre a spring security
       String encodePassword =
       bCryptPasswordEncoder.encode(appUser.getPassword());
       // ensuite on vien Setter le password encoder aux champs password de AppUser
       appUser.setPassword(encodePassword);
        appUserRepository.save(appUser);


       // send confirmation Token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token ,
                LocalDateTime.now() ,
                LocalDateTime.now().plusMinutes(15) ,
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

      // Todo Send Email

       return token ;
    }

    public void enableAppUser(String email) {
        appUserRepository.enableAppUser(email);
    }

}
