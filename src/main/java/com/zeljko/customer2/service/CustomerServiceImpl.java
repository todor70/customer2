package com.zeljko.customer2.service;

import javax.transaction.Transactional;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
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
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(long id, Customer customerUpdate) {
        Customer customer = customerRepository.findById(id).get();

        customer.setFirstName(customerUpdate.getFirstName());
        customer.setLastName(customerUpdate.getLastName());
        customer.setEmail(customerUpdate.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    public Customer patch(long id, Customer customerPatch) {
        Customer customer = customerRepository.findById(id).get();

        if (customerPatch.getFirstName() != null) {
            customer.setFirstName(customerPatch.getFirstName());
        }
        if (customerPatch.getLastName() != null) {
            customer.setLastName(customerPatch.getLastName());
        }
        if (customerPatch.getEmail() != null) {
            customer.setEmail(customerPatch.getEmail());
        }

        return customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

}
