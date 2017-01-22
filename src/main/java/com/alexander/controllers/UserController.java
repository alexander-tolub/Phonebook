package com.alexander.controllers;

import com.alexander.config.annotation.WebController;
import com.alexander.entities.User;
import com.alexander.services.SecurityService;
import com.alexander.services.UserService;
import com.alexander.validation.UserValidator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by alex on 20.01.2017.
 */
@WebController
public class UserController {

    @Inject
    private UserService userService;
    @Inject
    private SecurityService securityService;
    @Inject
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model)
    {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userFrom") User userForm, BindingResult bindingResult, Model model)
    {

        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors())
        {
            model.addAttribute("userForm", userForm);
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        if(logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }
}