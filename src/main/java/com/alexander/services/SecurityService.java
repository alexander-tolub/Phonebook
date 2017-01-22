package com.alexander.services;

/**
 * Created by alex on 20.01.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
