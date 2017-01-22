package com.alexander.services;

import com.alexander.entities.Customer;

import java.util.List;

/**
 * Created by alex on 07.01.2017.
 */
public interface CustomerService {

    public List<Customer> getPageOfCustomers(Long page);

}
