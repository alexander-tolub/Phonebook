package com.alexander.validation;


import com.alexander.entities.User;
import com.alexander.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.inject.Inject;

/**
 * Created by alex on 24.11.2016.
 */

@Component
public class UserValidator implements Validator {

    @Inject
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if(user.getUsername().length() < 8 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Should be 8 to 32");
        }

        if(userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "such user already exists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if(user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size of password is unacceptable.");
        }

        if(!user.getConfirmPassword().equals(user.getPassword()))
        {
            errors.rejectValue("confirmPassword", "Passwords don't match");
        }
    }
}
