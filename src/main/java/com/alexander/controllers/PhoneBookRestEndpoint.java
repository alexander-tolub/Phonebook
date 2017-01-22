package com.alexander.controllers;

import com.alexander.config.annotation.RestEndpoint;
import com.alexander.entities.Customer;
import com.alexander.entities.PhoneNumber;
import com.alexander.services.CustomerService;
import com.alexander.services.PhoneNumberService;
import com.alexander.util.PhoneType;
import com.alexander.validation.PhoneNumbersValidator;
import com.alexander.validation.errors.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alex on 08.01.2017.
 */
@RestEndpoint
public class PhoneBookRestEndpoint {

    @Inject
    CustomerService customerService;
    @Inject
    PhoneNumberService phoneNumberService;
    @Inject
    PhoneNumbersValidator phoneNumbersValidator;

    @RequestMapping(value = "/updatePhones", method = RequestMethod.PUT)
    @ResponseBody @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePhones(@RequestBody List<PhoneNumber> phoneNumbers , BindingResult bindingResult)
    {
        phoneNumbersValidator.validate(phoneNumbers, bindingResult);
        if(bindingResult.hasErrors())
        {
            throw new InvalidRequestException("Invalid fields", bindingResult);
        } else {
            phoneNumberService.updatePhoneNumbers(phoneNumbers);
        }
    }

    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    @ResponseBody @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers(@RequestParam long page)
    {
        List<Customer> customers = customerService.getPageOfCustomers(page);
        return customers;
    }

    @RequestMapping(value = "/getPhoneTypes", method = RequestMethod.GET)
    @ResponseBody @ResponseStatus(HttpStatus.OK)
    public PhoneType[] getPhoneTypes()
    {
        return PhoneType.values();
    }

}
