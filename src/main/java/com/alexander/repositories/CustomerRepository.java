package com.alexander.repositories;

import com.alexander.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alex on 07.01.2017.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
