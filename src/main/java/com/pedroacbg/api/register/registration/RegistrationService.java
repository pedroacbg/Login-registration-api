package com.pedroacbg.api.register.registration;

import com.pedroacbg.api.register.appuser.AppUser;
import com.pedroacbg.api.register.appuser.AppUserRole;
import com.pedroacbg.api.register.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail =  emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(new AppUser(request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(), AppUserRole.USER));
    }

}
