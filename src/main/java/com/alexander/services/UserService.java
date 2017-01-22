package com.alexander.services;


import com.alexander.entities.User;

/**
 * Created by alex on 24.11.2016.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
