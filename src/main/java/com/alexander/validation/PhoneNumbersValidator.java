package com.alexander.validation;

import com.alexander.entities.PhoneNumber;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alex on 11.01.2017.
 */
@Service
public class PhoneNumbersValidator implements Validator {

    @Inject
    LocalValidatorFactoryBean validator;

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        List<PhoneNumber> phoneNumbers = (List<PhoneNumber>) target;

        int idx = 0;
        for(PhoneNumber phoneNumber : phoneNumbers) {
            errors.pushNestedPath("listObjects[" + idx + "]");
            validator.validate(phoneNumber, errors);
            errors.popNestedPath();
            idx++;
        }
    }
}
