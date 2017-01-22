package com.alexander.controllers;

import com.alexander.config.annotation.WebController;
import com.alexander.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by alex on 06.01.2017.
 */

@WebController
public class PhoneBookController {

    @Inject
    CustomerService customerService;

    @RequestMapping("/")
    public ModelAndView mainPage()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

}