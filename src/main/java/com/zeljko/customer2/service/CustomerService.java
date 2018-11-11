package com.zeljko.customer2.service;

import com.zeljko.customer2.entity.Customer;

public interface CustomerService {

    Iterable<Customer> list();

    Customer create(Customer customer);

    Customer read(long id);

    Customer update(long id, Customer customer);

    Customer patch(long id, Customer customer);

    void delete(long id);
}
