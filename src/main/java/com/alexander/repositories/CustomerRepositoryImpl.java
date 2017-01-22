package com.alexander.repositories;

import com.alexander.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alex on 08.01.2017.
 */
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> getPageOfCustomers(Long page) {
        List<Customer> customers = entityManager.createQuery("SELECT DISTINCT c FROM Customer c")
                .setFirstResult((int)(10*page))
                .setMaxResults((int)((page+1)*10))
                .getResultList();
        return customers;
    }
}
