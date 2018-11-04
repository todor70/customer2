package com.zeljko.customer2.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.repository.CustomerRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void list(){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1L,"mare","maric","mare@gmail.com"));
        customerList.add(new Customer(2L,"pera","peric","pera@gmail.com"));
        when(customerRepository.findAll()).thenReturn(customerList);

        List<Customer> result = Lists.newArrayList(customerService.list());
        assertEquals(2, result.size());
    }

    @Test
    public void create(){
        Customer customer = new Customer(3L,"mare","maric","mare@gmail.com");
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer result = customerService.create(customer);
        assertEquals("3", result.getId().toString());
        assertEquals("mare", result.getFirstName());
        assertEquals("maric", result.getLastName());
        assertEquals("mare@gmail.com", result.getEmail());

    }

    @Test
    public void delete(){
        customerService.delete(3L);
        verify(customerRepository, times(1)).deleteById(3L);
    }


}