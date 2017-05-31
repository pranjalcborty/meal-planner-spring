package net.therap.mealplannerspring.web.validator;

import net.therap.mealplannerspring.domain.UserLogin;
import net.therap.mealplannerspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserLoginValidator implements Validator {
    @Autowired
    private UserService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserLogin.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserLogin userLogin = (UserLogin) target;

        if(!service.isAllowed(userLogin)) {
            errors.reject("userNotAllowed");
        }
    }
}
