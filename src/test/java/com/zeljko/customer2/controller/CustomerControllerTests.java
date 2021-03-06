package com.zeljko.customer2.controller;

import com.zeljko.customer2.entity.Customer;
import com.zeljko.customer2.service.CustomerService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTests {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;


/* @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }*/


    @Test
    public void list(){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("mare","maric","mare@gmail.com"));
        customerList.add(new Customer("pera","peric","pera@gmail.com"));
        when(customerController.list()).thenReturn(customerList);
        List<Customer> result = Lists.newArrayList(customerController.list());
        assertEquals(2, result.size());
    }

    @Test
    public void read(){
        Customer customer = new Customer("5bfc48f7dc45c0149cbf3cb8","zare","zaric","zare@gmail.com");
        when(customerService.read("5bfc48f7dc45c0149cbf3cb8")).thenReturn(customer);
        Customer result = customerController.read("5bfc48f7dc45c0149cbf3cb8");
        assertEquals("5bfc48f7dc45c0149cbf3cb8",result.getId().toString());
        assertEquals("zare", result.getFirstName());
        assertEquals("zaric", result.getLastName());
        assertEquals("zare@gmail.com", result.getEmail());
    }

    @Test
    public void create(){
        Customer customer = new Customer("mare","maric","mare@gmail.com");
        when(customerService.create(customer)).thenReturn(customer);
        Customer result = customerController.create(customer);
        assertEquals("mare", result.getFirstName());
        assertEquals("maric", result.getLastName());
        assertEquals("mare@gmail.com", result.getEmail());

    }

    @Test
    public void delete(){
        customerController.delete("5bfc48f7dc45c0149cbf3cb8");
        verify(customerService, times(1)).delete("5bfc48f7dc45c0149cbf3cb8");
    }
}
