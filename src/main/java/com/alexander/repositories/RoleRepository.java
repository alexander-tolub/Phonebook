package com.alexander.repositories;

import com.alexander.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alex on 24.11.2016.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
