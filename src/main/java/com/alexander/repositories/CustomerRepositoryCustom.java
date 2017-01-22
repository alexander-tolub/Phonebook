package com.alexander.repositories;

import com.alexander.entities.Customer;

import java.util.List;

/**
 * Created by alex on 08.01.2017.
 */
public interface CustomerRepositoryCustom {

    List<Customer> getPageOfCustomers(Long page);

}
