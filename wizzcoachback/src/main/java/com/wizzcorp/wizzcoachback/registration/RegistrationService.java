package com.wizzcorp.wizzcoachback.registration;


import com.wizzcorp.wizzcoachback.appuser.AppUser;
import com.wizzcorp.wizzcoachback.appuser.AppUserRole;
import com.wizzcorp.wizzcoachback.appuser.AppUserService;
import com.wizzcorp.wizzcoachback.registration.token.ConfirmationToken;
import com.wizzcorp.wizzcoachback.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
      private final ConfirmationTokenService confirmationTokenService;



    public String register(RegistrationRequest request) {

    // verify l'email
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw  new IllegalStateException("email not valid");

        }

        // Si l'email est bien validé on créer un nouvelle user

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName() ,
                        request.getLastName() ,
                        request.getEmail(),
                        request.getPassword() ,
                        AppUserRole.ADMIN

                )
        );



    }
    @Transactional
    public String confirmToken(String token) {

        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found")
                );
        if (confirmationToken.getConfirmedAt() != null) {

            throw new IllegalStateException("email alreay confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw  new IllegalStateException("token expired");

        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(  confirmationToken.getAppUser().getEmail());
            return "confirmed";
    }



}
