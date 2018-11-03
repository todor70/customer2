package com.zeljko.customer2.service;

import javax.transaction.Transactional;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Customer read(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(long id, Customer update) {
        Customer customer = customerRepository.findById(id).get();
        if( update.getLastName() != null ) {
            customer.setLastName(update.getLastName());
        }
        return customerRepository.save(customer);
    }
}
