package com.alexander.services;

import com.alexander.entities.Customer;
import com.alexander.repositories.CustomerRepositoryCustom;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alex on 08.01.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private CustomerRepositoryCustom customerRepositoryCustom;

    @Override
    public List<Customer> getPageOfCustomers(Long page) {
        return customerRepositoryCustom.getPageOfCustomers(page);
    }
}
