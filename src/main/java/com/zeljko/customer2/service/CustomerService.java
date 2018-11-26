package com.zeljko.customer2.service;

import com.zeljko.customer2.entity.Customer;

public interface CustomerService {

    Iterable<Customer> list();

    Customer create(Customer customer);

    Customer read(String id);

    Customer update(String id, Customer customer);

    Customer patch(String id, Customer customer);

    void delete(String id);
}
