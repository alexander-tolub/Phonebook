package com.alexander.repositories;

import com.alexander.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alex on 20.01.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}