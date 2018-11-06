package com.zeljko.customer2.repository;

import com.zeljko.customer2.entity.Customer;
import org.assertj.core.util.IterableUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryDataJpaTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findAllCustomers() throws Exception{
        Iterable<Customer> customers = customerRepository.findAll();
        assertEquals(2, IterableUtil.sizeOf(customers));
    }

    @Test
    public void findCustomerById() throws Exception{
        Customer customer = customerRepository.findById(1L).get();
        assertEquals("marko",customer.getFirstName());
        assertEquals("markovic", customer.getLastName());
        assertEquals("marko@gmail.com", customer.getEmail());
    }

}
